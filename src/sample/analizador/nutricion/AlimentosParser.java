// Generated from C:/Users/fidxl/dev/automatas_2/diet_maker/src/sample/analizador/nutricion\Alimentos.g4 by ANTLR 4.9
package sample.analizador.nutricion;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlimentosParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT=6, FLOAT=7, GRAMOS=8, TEXTO=9, 
		IGNORAR=10;
	public static final int
		RULE_archivo = 0, RULE_persona = 1, RULE_edad = 2, RULE_peso = 3, RULE_genero = 4, 
		RULE_altura = 5, RULE_platos = 6, RULE_desayuno = 7, RULE_comida = 8, 
		RULE_cena = 9, RULE_tipoPlato = 10, RULE_alimento = 11, RULE_cantidad = 12, 
		RULE_gramos = 13, RULE_nombre = 14, RULE_tipo = 15, RULE_peso_alimento = 16, 
		RULE_calorias = 17, RULE_proteinas = 18, RULE_lipidos = 19, RULE_carbohidratos = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"archivo", "persona", "edad", "peso", "genero", "altura", "platos", "desayuno", 
			"comida", "cena", "tipoPlato", "alimento", "cantidad", "gramos", "nombre", 
			"tipo", "peso_alimento", "calorias", "proteinas", "lipidos", "carbohidratos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'DESAYUNO'", "'COMIDA'", "'CENA'", "' '", null, null, "'gr'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "INT", "FLOAT", "GRAMOS", "TEXTO", 
			"IGNORAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "Alimentos.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlimentosParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ArchivoContext extends ParserRuleContext {
		public PersonaContext persona() {
			return getRuleContext(PersonaContext.class,0);
		}
		public PlatosContext platos() {
			return getRuleContext(PlatosContext.class,0);
		}
		public ArchivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archivo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitArchivo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchivoContext archivo() throws RecognitionException {
		ArchivoContext _localctx = new ArchivoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_archivo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			persona();
			setState(43);
			platos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PersonaContext extends ParserRuleContext {
		public NombreContext nombre() {
			return getRuleContext(NombreContext.class,0);
		}
		public EdadContext edad() {
			return getRuleContext(EdadContext.class,0);
		}
		public PesoContext peso() {
			return getRuleContext(PesoContext.class,0);
		}
		public AlturaContext altura() {
			return getRuleContext(AlturaContext.class,0);
		}
		public GeneroContext genero() {
			return getRuleContext(GeneroContext.class,0);
		}
		public PersonaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_persona; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitPersona(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonaContext persona() throws RecognitionException {
		PersonaContext _localctx = new PersonaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_persona);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			nombre();
			setState(46);
			match(T__0);
			setState(47);
			edad();
			setState(48);
			match(T__0);
			setState(49);
			peso();
			setState(50);
			match(T__0);
			setState(51);
			altura();
			setState(52);
			match(T__0);
			setState(53);
			genero();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdadContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlimentosParser.INT, 0); }
		public EdadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edad; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitEdad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdadContext edad() throws RecognitionException {
		EdadContext _localctx = new EdadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edad);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PesoContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public PesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_peso; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitPeso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PesoContext peso() throws RecognitionException {
		PesoContext _localctx = new PesoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_peso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneroContext extends ParserRuleContext {
		public TerminalNode TEXTO() { return getToken(AlimentosParser.TEXTO, 0); }
		public GeneroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genero; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitGenero(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneroContext genero() throws RecognitionException {
		GeneroContext _localctx = new GeneroContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_genero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(TEXTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlturaContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public AlturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altura; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitAltura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlturaContext altura() throws RecognitionException {
		AlturaContext _localctx = new AlturaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_altura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlatosContext extends ParserRuleContext {
		public DesayunoContext desayuno() {
			return getRuleContext(DesayunoContext.class,0);
		}
		public ComidaContext comida() {
			return getRuleContext(ComidaContext.class,0);
		}
		public CenaContext cena() {
			return getRuleContext(CenaContext.class,0);
		}
		public PlatosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_platos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitPlatos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlatosContext platos() throws RecognitionException {
		PlatosContext _localctx = new PlatosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_platos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			desayuno();
			setState(64);
			comida();
			setState(65);
			cena();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesayunoContext extends ParserRuleContext {
		public TipoPlatoContext tipoPlato() {
			return getRuleContext(TipoPlatoContext.class,0);
		}
		public List<AlimentoContext> alimento() {
			return getRuleContexts(AlimentoContext.class);
		}
		public AlimentoContext alimento(int i) {
			return getRuleContext(AlimentoContext.class,i);
		}
		public DesayunoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desayuno; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitDesayuno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesayunoContext desayuno() throws RecognitionException {
		DesayunoContext _localctx = new DesayunoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_desayuno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			tipoPlato();
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				alimento();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLOAT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComidaContext extends ParserRuleContext {
		public TipoPlatoContext tipoPlato() {
			return getRuleContext(TipoPlatoContext.class,0);
		}
		public List<AlimentoContext> alimento() {
			return getRuleContexts(AlimentoContext.class);
		}
		public AlimentoContext alimento(int i) {
			return getRuleContext(AlimentoContext.class,i);
		}
		public ComidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comida; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitComida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComidaContext comida() throws RecognitionException {
		ComidaContext _localctx = new ComidaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			tipoPlato();
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				alimento();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLOAT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CenaContext extends ParserRuleContext {
		public TipoPlatoContext tipoPlato() {
			return getRuleContext(TipoPlatoContext.class,0);
		}
		public List<AlimentoContext> alimento() {
			return getRuleContexts(AlimentoContext.class);
		}
		public AlimentoContext alimento(int i) {
			return getRuleContext(AlimentoContext.class,i);
		}
		public CenaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cena; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitCena(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CenaContext cena() throws RecognitionException {
		CenaContext _localctx = new CenaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cena);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			tipoPlato();
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				alimento();
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLOAT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoPlatoContext extends ParserRuleContext {
		public TipoPlatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoPlato; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitTipoPlato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoPlatoContext tipoPlato() throws RecognitionException {
		TipoPlatoContext _localctx = new TipoPlatoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipoPlato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlimentoContext extends ParserRuleContext {
		public CantidadContext cantidad() {
			return getRuleContext(CantidadContext.class,0);
		}
		public NombreContext nombre() {
			return getRuleContext(NombreContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Peso_alimentoContext peso_alimento() {
			return getRuleContext(Peso_alimentoContext.class,0);
		}
		public CaloriasContext calorias() {
			return getRuleContext(CaloriasContext.class,0);
		}
		public ProteinasContext proteinas() {
			return getRuleContext(ProteinasContext.class,0);
		}
		public LipidosContext lipidos() {
			return getRuleContext(LipidosContext.class,0);
		}
		public CarbohidratosContext carbohidratos() {
			return getRuleContext(CarbohidratosContext.class,0);
		}
		public AlimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alimento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitAlimento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlimentoContext alimento() throws RecognitionException {
		AlimentoContext _localctx = new AlimentoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_alimento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(87);
			cantidad();
			setState(88);
			match(T__0);
			setState(89);
			nombre();
			setState(90);
			match(T__0);
			setState(91);
			tipo();
			setState(92);
			match(T__0);
			setState(93);
			peso_alimento();
			setState(94);
			match(T__0);
			setState(95);
			calorias();
			setState(96);
			match(T__0);
			setState(97);
			proteinas();
			setState(98);
			match(T__0);
			setState(99);
			lipidos();
			setState(100);
			match(T__0);
			setState(101);
			carbohidratos();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CantidadContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public GramosContext gramos() {
			return getRuleContext(GramosContext.class,0);
		}
		public CantidadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cantidad; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitCantidad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CantidadContext cantidad() throws RecognitionException {
		CantidadContext _localctx = new CantidadContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cantidad);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(FLOAT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				gramos();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GramosContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public TerminalNode GRAMOS() { return getToken(AlimentosParser.GRAMOS, 0); }
		public GramosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitGramos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramosContext gramos() throws RecognitionException {
		GramosContext _localctx = new GramosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_gramos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(FLOAT);
			setState(108);
			match(GRAMOS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NombreContext extends ParserRuleContext {
		public List<TerminalNode> TEXTO() { return getTokens(AlimentosParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(AlimentosParser.TEXTO, i);
		}
		public NombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nombre; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NombreContext nombre() throws RecognitionException {
		NombreContext _localctx = new NombreContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nombre);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(TEXTO);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(111);
				match(T__4);
				setState(112);
				match(TEXTO);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public List<TerminalNode> TEXTO() { return getTokens(AlimentosParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(AlimentosParser.TEXTO, i);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TEXTO);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(119);
				match(T__4);
				setState(120);
				match(TEXTO);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Peso_alimentoContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public Peso_alimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_peso_alimento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitPeso_alimento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Peso_alimentoContext peso_alimento() throws RecognitionException {
		Peso_alimentoContext _localctx = new Peso_alimentoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_peso_alimento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaloriasContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public CaloriasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calorias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitCalorias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaloriasContext calorias() throws RecognitionException {
		CaloriasContext _localctx = new CaloriasContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_calorias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProteinasContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public ProteinasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proteinas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitProteinas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProteinasContext proteinas() throws RecognitionException {
		ProteinasContext _localctx = new ProteinasContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_proteinas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LipidosContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public LipidosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lipidos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitLipidos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LipidosContext lipidos() throws RecognitionException {
		LipidosContext _localctx = new LipidosContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lipidos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CarbohidratosContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AlimentosParser.FLOAT, 0); }
		public CarbohidratosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_carbohidratos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitCarbohidratos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CarbohidratosContext carbohidratos() throws RecognitionException {
		CarbohidratosContext _localctx = new CarbohidratosContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_carbohidratos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\u008b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\6\tH\n\t\r\t\16\tI\3\n\3\n\6\nN\n\n\r\n\16\nO\3\13\3\13\6\13"+
		"T\n\13\r\13\16\13U\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16l\n\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\7\20t\n\20\f\20\16\20w\13\20\3\21\3\21\3\21\7\21|\n\21\f\21\16\21\177"+
		"\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\2\27\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3\2\4\6\2{\2,\3\2\2\2"+
		"\4/\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\n=\3\2\2\2\f?\3\2\2\2\16A\3\2\2\2\20"+
		"E\3\2\2\2\22K\3\2\2\2\24Q\3\2\2\2\26W\3\2\2\2\30Y\3\2\2\2\32k\3\2\2\2"+
		"\34m\3\2\2\2\36p\3\2\2\2 x\3\2\2\2\"\u0080\3\2\2\2$\u0082\3\2\2\2&\u0084"+
		"\3\2\2\2(\u0086\3\2\2\2*\u0088\3\2\2\2,-\5\4\3\2-.\5\16\b\2.\3\3\2\2\2"+
		"/\60\5\36\20\2\60\61\7\3\2\2\61\62\5\6\4\2\62\63\7\3\2\2\63\64\5\b\5\2"+
		"\64\65\7\3\2\2\65\66\5\f\7\2\66\67\7\3\2\2\678\5\n\6\28\5\3\2\2\29:\7"+
		"\b\2\2:\7\3\2\2\2;<\7\t\2\2<\t\3\2\2\2=>\7\13\2\2>\13\3\2\2\2?@\7\t\2"+
		"\2@\r\3\2\2\2AB\5\20\t\2BC\5\22\n\2CD\5\24\13\2D\17\3\2\2\2EG\5\26\f\2"+
		"FH\5\30\r\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\21\3\2\2\2KM\5\26"+
		"\f\2LN\5\30\r\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\23\3\2\2\2QS"+
		"\5\26\f\2RT\5\30\r\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\25\3\2\2"+
		"\2WX\t\2\2\2X\27\3\2\2\2YZ\5\32\16\2Z[\7\3\2\2[\\\5\36\20\2\\]\7\3\2\2"+
		"]^\5 \21\2^_\7\3\2\2_`\5\"\22\2`a\7\3\2\2ab\5$\23\2bc\7\3\2\2cd\5&\24"+
		"\2de\7\3\2\2ef\5(\25\2fg\7\3\2\2gh\5*\26\2h\31\3\2\2\2il\7\t\2\2jl\5\34"+
		"\17\2ki\3\2\2\2kj\3\2\2\2l\33\3\2\2\2mn\7\t\2\2no\7\n\2\2o\35\3\2\2\2"+
		"pu\7\13\2\2qr\7\7\2\2rt\7\13\2\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2"+
		"\2v\37\3\2\2\2wu\3\2\2\2x}\7\13\2\2yz\7\7\2\2z|\7\13\2\2{y\3\2\2\2|\177"+
		"\3\2\2\2}{\3\2\2\2}~\3\2\2\2~!\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\t\2"+
		"\2\u0081#\3\2\2\2\u0082\u0083\7\t\2\2\u0083%\3\2\2\2\u0084\u0085\7\t\2"+
		"\2\u0085\'\3\2\2\2\u0086\u0087\7\t\2\2\u0087)\3\2\2\2\u0088\u0089\7\t"+
		"\2\2\u0089+\3\2\2\2\bIOUku}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}