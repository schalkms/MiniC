package ms.minic.parser;

import ms.minic.MCLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.source.Source;
import ms.minic.nodes.arithmetic.MCAddNode;
import ms.minic.nodes.arithmetic.MCDivNode;
import ms.minic.nodes.arithmetic.MCMulNode;
import ms.minic.nodes.arithmetic.MCSubNode;
import ms.minic.nodes.arithmetic.MCParenExpressionNode;
import ms.minic.nodes.MCAssignNode;
import ms.minic.nodes.MCExpressionNode;
import ms.minic.nodes.MCIntNode;
import ms.minic.nodes.MCNode;
import ms.minic.nodes.MCPrintNode;
import ms.minic.nodes.MCRootNode;
import ms.minic.nodes.MCSymbolNode;
import ms.minic.parser.generated.MiniCBaseVisitor;
import ms.minic.parser.generated.MiniCLexer;
import ms.minic.parser.generated.MiniCParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MCReader extends MiniCBaseVisitor<MCNode> {

    private final Source source;
    private final ArrayList<MCNode> nodes = new ArrayList<>();
    private final HashMap<String, MCSymbolNode> symbols = new HashMap<>();

    public MCReader(Source source) {
        this.source = source;
    }

    public MCRootNode Read(MCLanguage language) throws IOException {
        FrameDescriptor frameDescriptor = new FrameDescriptor();
        visit(createParseTree());
        return new MCRootNode(language, frameDescriptor, nodes);
    }

    private ParseTree createParseTree() throws IOException {
        InputStream inputStream = source.getInputStream();
        ANTLRInputStream stream = new ANTLRInputStream(inputStream);
        MiniCLexer lexer = new MiniCLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniCParser parser = new MiniCParser(tokens);
        MiniCParser.McContext mc = parser.mc();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new MCLanguageException("Parsing the input file was unsuccessful");
        }
        return mc;
    }

    @Override
    public MCNode visitVarDecl(MiniCParser.VarDeclContext ctx) {
        for (TerminalNode identNode : ctx.IDENT()) {
            String ident = identNode.getText();
            MCSymbolNode symbolNode = symbols.put(ident, new MCSymbolNode(ident));
            if (symbolNode != null) {
                throw new MCLanguageException("Defined variable with name " + ident + " already exists");
            }
        }
        return super.visitVarDecl(ctx);
    }

    @Override
    public MCNode visitAssign(MiniCParser.AssignContext ctx) {
        MCExpressionNode exprNode = (MCExpressionNode) visit(ctx.expr());
        MCSymbolNode symbolNode = getSymbol(ctx.IDENT().getText());
        nodes.add(new MCAssignNode(symbolNode, exprNode));
        return super.visitAssign(ctx);
    }

    @Override
    public MCNode visitPrint(MiniCParser.PrintContext ctx) {
        MCExpressionNode exprNode = (MCExpressionNode) visit(ctx.expr());
        nodes.add(new MCPrintNode(exprNode));
        return super.visitPrint(ctx);
    }

    @Override
    public MCNode visitMulDiv(MiniCParser.MulDivContext ctx) {
        MCExpressionNode left = (MCExpressionNode) visit(ctx.expr(0));
        MCExpressionNode right = (MCExpressionNode) visit(ctx.expr(1));
        int type = ctx.op.getType();
        if (type == MiniCParser.MUL) {
            return new MCMulNode(left, right);
        } else if (type == MiniCParser.DIV) {
            return new MCDivNode(left, right);
        }
        throw new MCLanguageException("Invalid operator " + ctx.op.getText());
    }

    @Override
    public MCNode visitAddSub(MiniCParser.AddSubContext ctx) {
        MCExpressionNode left = (MCExpressionNode) visit(ctx.expr(0));
        MCExpressionNode right = (MCExpressionNode) visit(ctx.expr(1));
        int type = ctx.op.getType();
        if (type == MiniCParser.ADD) {
            return new MCAddNode(left, right);
        } else if (type == MiniCParser.SUB) {
            return new MCSubNode(left, right);
        }
        throw new MCLanguageException("Invalid operator " + ctx.op.getText());
    }

    @Override
    public MCNode visitNumber(MiniCParser.NumberContext ctx) {
        Integer value = Integer.valueOf(ctx.NUMBER().getText());
        return new MCIntNode(value);
    }

    @Override
    public MCNode visitIdent(MiniCParser.IdentContext ctx) {
        String ident = ctx.IDENT().getText();
        return getSymbol(ident);
    }

    @Override
    public MCNode visitParens(MiniCParser.ParensContext ctx) {
        MCExpressionNode expr = (MCExpressionNode) visit(ctx.expr());
        return new MCParenExpressionNode(expr);
    }

    private MCSymbolNode getSymbol(String ident) {
        MCSymbolNode symbolNode = symbols.get(ident);
        if (symbolNode == null) {
            throw new MCLanguageException("Symbol with name " + ident + " does not exist");
        }
        return symbolNode;
    }
}
