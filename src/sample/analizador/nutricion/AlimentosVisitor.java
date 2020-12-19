// Generated from C:/Users/fidxl/dev/automatas_2/diet_maker/src/sample/analizador/nutricion\Alimentos.g4 by ANTLR 4.9
package sample.analizador.nutricion;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlimentosParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlimentosVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(AlimentosParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#persona}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersona(AlimentosParser.PersonaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#edad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdad(AlimentosParser.EdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#peso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeso(AlimentosParser.PesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#genero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenero(AlimentosParser.GeneroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#altura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltura(AlimentosParser.AlturaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#platos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlatos(AlimentosParser.PlatosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#desayuno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesayuno(AlimentosParser.DesayunoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#comida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComida(AlimentosParser.ComidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#cena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCena(AlimentosParser.CenaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#tipoPlato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoPlato(AlimentosParser.TipoPlatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#alimento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlimento(AlimentosParser.AlimentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#cantidad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCantidad(AlimentosParser.CantidadContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#gramos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramos(AlimentosParser.GramosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#nombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNombre(AlimentosParser.NombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(AlimentosParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#peso_alimento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeso_alimento(AlimentosParser.Peso_alimentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#calorias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalorias(AlimentosParser.CaloriasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#proteinas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProteinas(AlimentosParser.ProteinasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#lipidos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLipidos(AlimentosParser.LipidosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#carbohidratos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCarbohidratos(AlimentosParser.CarbohidratosContext ctx);
}