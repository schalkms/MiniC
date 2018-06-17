// Generated from ../Documents/MiniC/lang/src/main/java/ms/minic/parser/generated/MiniC.g4 by ANTLR 4.7.1

    package ms.minic.parser.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, IDENT=12, STRING=13, NUMBER=14, ADD=15, SUB=16, MUL=17, 
		DIV=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "IDENT", "STRING", "NUMBER", "ADD", "SUB", "MUL", "DIV", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "'int'", "','", 
		"';'", "'='", "'printf'", null, null, null, "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"IDENT", "STRING", "NUMBER", "ADD", "SUB", "MUL", "DIV", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MiniCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\rO\n\r\f\r\16\rR\13\r\3\16\3\16\3\16"+
		"\3\16\7\16X\n\16\f\16\16\16[\13\16\3\16\3\16\3\17\6\17`\n\17\r\17\16\17"+
		"a\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\2\2\25\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\3\2\62;\5\2"+
		"\13\f\17\17\"\"\2r\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5.\3\2\2\2\7\63"+
		"\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21?\3\2\2\2"+
		"\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31L\3\2\2\2\33S\3\2\2\2\35_\3\2\2"+
		"\2\37c\3\2\2\2!e\3\2\2\2#g\3\2\2\2%i\3\2\2\2\'k\3\2\2\2)*\7x\2\2*+\7q"+
		"\2\2+,\7k\2\2,-\7f\2\2-\4\3\2\2\2./\7o\2\2/\60\7c\2\2\60\61\7k\2\2\61"+
		"\62\7p\2\2\62\6\3\2\2\2\63\64\7*\2\2\64\b\3\2\2\2\65\66\7+\2\2\66\n\3"+
		"\2\2\2\678\7}\2\28\f\3\2\2\29:\7\177\2\2:\16\3\2\2\2;<\7k\2\2<=\7p\2\2"+
		"=>\7v\2\2>\20\3\2\2\2?@\7.\2\2@\22\3\2\2\2AB\7=\2\2B\24\3\2\2\2CD\7?\2"+
		"\2D\26\3\2\2\2EF\7r\2\2FG\7t\2\2GH\7k\2\2HI\7p\2\2IJ\7v\2\2JK\7h\2\2K"+
		"\30\3\2\2\2LP\t\2\2\2MO\t\3\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2"+
		"\2Q\32\3\2\2\2RP\3\2\2\2SY\7$\2\2TX\n\4\2\2UV\7^\2\2VX\7$\2\2WT\3\2\2"+
		"\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7$"+
		"\2\2]\34\3\2\2\2^`\t\5\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\36"+
		"\3\2\2\2cd\7-\2\2d \3\2\2\2ef\7/\2\2f\"\3\2\2\2gh\7,\2\2h$\3\2\2\2ij\7"+
		"\61\2\2j&\3\2\2\2kl\t\6\2\2lm\3\2\2\2mn\b\24\2\2n(\3\2\2\2\7\2PWYa\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}