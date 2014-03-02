
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object tables extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[DBPokerTable],Form[dto.PokerTable],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tables: List[DBPokerTable], tableForm: Form[dto.PokerTable]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Poker Game - Tables")/*5.29*/ {_display_(Seq[Any](format.raw/*5.31*/("""

	<h1>Tables</h1>
	<table class="tableList">
		<tr>
			<th>Name</th>
			<th>Type</th>
			<th>Limit</th>
			<th>Size</th>
		</tr>
		"""),_display_(Seq[Any](/*15.4*/for(table <- tables) yield /*15.24*/ {_display_(Seq[Any](format.raw/*15.26*/("""
			<tr>
				<td><a href=""""),_display_(Seq[Any](/*17.19*/routes/*17.25*/.Tables.openTable(table.getName()))),format.raw/*17.59*/("""">"""),_display_(Seq[Any](/*17.62*/table/*17.67*/.getName())),format.raw/*17.77*/("""</a></td>
				<td>"""),_display_(Seq[Any](/*18.10*/table/*18.15*/.getTableType())),format.raw/*18.30*/("""</td>
				<td>"""),_display_(Seq[Any](/*19.10*/table/*19.15*/.getTableLimit())),format.raw/*19.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*20.10*/table/*20.15*/.getSeatNumber())),format.raw/*20.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*21.10*/form(routes.Tables.deleteTable(table.getName()))/*21.58*/ {_display_(Seq[Any](format.raw/*21.60*/(""" <input
					type="submit" value="Delete"> """)))})),format.raw/*22.37*/("""
				</td>
			</tr>
		""")))})),format.raw/*25.4*/("""
	</table>
	
	<h2>Add a new table</h2>
	
	"""),_display_(Seq[Any](/*30.3*/if(tableForm.hasGlobalErrors)/*30.32*/ {_display_(Seq[Any](format.raw/*30.34*/("""
		<p class="error">"""),_display_(Seq[Any](/*31.21*/tableForm/*31.30*/.globalError.message)),format.raw/*31.50*/("""</p>
	""")))})),format.raw/*32.3*/("""
	
	"""),_display_(Seq[Any](/*34.3*/form(routes.Tables.newTable())/*34.33*/ {_display_(Seq[Any](format.raw/*34.35*/("""
		"""),_display_(Seq[Any](/*35.4*/inputText(tableForm("name")))),format.raw/*35.32*/("""
		"""),_display_(Seq[Any](/*36.4*/inputRadioGroup(tableForm("tableType"), options = options("HOLDEM"->"Hold'em","OMAHA"->"Omaha")))),format.raw/*36.100*/("""
		"""),_display_(Seq[Any](/*37.4*/inputRadioGroup(tableForm("tableLimit"), options =	options("LIMIT"->"Limit","POT_LIMIT"->"Pot Limit", "NO_LIMIT"->"No Limit")))),format.raw/*37.130*/("""
		"""),_display_(Seq[Any](/*38.4*/inputRadioGroup(tableForm("seatNumber"), options = options("2"->"2","6"->"6", "9"->"9", "10"->"10")))),format.raw/*38.104*/("""
		
		<input type="submit" value="Create">
	""")))})),format.raw/*41.3*/("""

""")))})),format.raw/*43.2*/("""
"""))}
    }
    
    def render(tables:List[DBPokerTable],tableForm:Form[dto.PokerTable]): play.api.templates.HtmlFormat.Appendable = apply(tables,tableForm)
    
    def f:((List[DBPokerTable],Form[dto.PokerTable]) => play.api.templates.HtmlFormat.Appendable) = (tables,tableForm) => apply(tables,tableForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 14:15:18 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/tables.scala.html
                    HASH: 16c5323a8be150936e0f13d2e2c637e2434a7cf0
                    MATRIX: 808->1|979->62|1007->81|1043->83|1078->110|1117->112|1285->245|1321->265|1361->267|1424->294|1439->300|1495->334|1534->337|1548->342|1580->352|1635->371|1649->376|1686->391|1737->406|1751->411|1789->427|1840->442|1854->447|1892->463|1943->478|2000->526|2040->528|2116->572|2170->595|2248->638|2286->667|2326->669|2383->690|2401->699|2443->719|2481->726|2521->731|2560->761|2600->763|2639->767|2689->795|2728->799|2847->895|2886->899|3035->1025|3074->1029|3197->1129|3273->1174|3307->1177
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|53->25|58->30|58->30|58->30|59->31|59->31|59->31|60->32|62->34|62->34|62->34|63->35|63->35|64->36|64->36|65->37|65->37|66->38|66->38|69->41|71->43
                    -- GENERATED --
                */
            