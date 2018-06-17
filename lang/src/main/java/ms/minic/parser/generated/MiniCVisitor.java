// Generated from ../Documents/MiniC/lang/src/main/java/ms/minic/parser/generated/MiniC.g4 by ANTLR 4.7.1

    package ms.minic.parser.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniCParser#mc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMc(MiniCParser.McContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MiniCParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#statSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatSeq(MiniCParser.StatSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(MiniCParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MiniCParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MiniCParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(MiniCParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MiniCParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(MiniCParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(MiniCParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(MiniCParser.ParensContext ctx);
}