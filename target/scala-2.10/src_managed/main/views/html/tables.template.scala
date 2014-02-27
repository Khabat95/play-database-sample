
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
object tables extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[PokerTable],Form[Tables.Table],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tables: List[PokerTable], tableForm: Form[Tables.Table]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.59*/("""

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
        """),_display_(Seq[Any](/*15.10*/for(table <- tables) yield /*15.30*/ {_display_(Seq[Any](format.raw/*15.32*/("""
	  		<tr>
	    		<td><a href=""""),_display_(Seq[Any](/*17.22*/routes/*17.28*/.Tables.openTable(table.getName()))),format.raw/*17.62*/("""">"""),_display_(Seq[Any](/*17.65*/table/*17.70*/.getName())),format.raw/*17.80*/("""</a></td>
	    		<td>"""),_display_(Seq[Any](/*18.13*/table/*18.18*/.getTableType())),format.raw/*18.33*/("""</td>
	    		<td>"""),_display_(Seq[Any](/*19.13*/table/*19.18*/.getTableLimit())),format.raw/*19.34*/("""</td>
	    		<td>"""),_display_(Seq[Any](/*20.13*/table/*20.18*/.getSeatNumber())),format.raw/*20.34*/("""</td>
	    		<td>
                """),_display_(Seq[Any](/*22.18*/form(routes.Tables.deleteTable(table.getName()))/*22.66*/ {_display_(Seq[Any](format.raw/*22.68*/("""
                    <input type="submit" value="Delete">
                """)))})),format.raw/*24.18*/("""
                </td>
	  		</tr>
        """)))})),format.raw/*27.10*/("""
	</table>
    
    <h2>Add a new table</h2>
    
	"""),_display_(Seq[Any](/*32.3*/if(tableForm.hasGlobalErrors)/*32.32*/ {_display_(Seq[Any](format.raw/*32.34*/("""
	    <p class="error">
	        """),_display_(Seq[Any](/*34.11*/tableForm/*34.20*/.globalError.message)),format.raw/*34.40*/("""
	    </p>
	""")))})),format.raw/*36.3*/("""

    """),_display_(Seq[Any](/*38.6*/form(routes.Tables.newTable())/*38.36*/ {_display_(Seq[Any](format.raw/*38.38*/("""
        
        """),_display_(Seq[Any](/*40.10*/inputText(tableForm("name")))),format.raw/*40.38*/(""" 
		"""),_display_(Seq[Any](/*41.4*/inputRadioGroup(
          tableForm("tableType"),
          options = options("HOLDEM"->"Hold'em","OMAHA"->"Omaha")))),format.raw/*43.67*/("""
		"""),_display_(Seq[Any](/*44.4*/inputRadioGroup(
          tableForm("tableLimit"),
          options = options("LIMIT"->"Limit","POT_LIMIT"->"Pot Limit", "NO_LIMIT"->"No Limit")))),format.raw/*46.96*/("""
		"""),_display_(Seq[Any](/*47.4*/inputRadioGroup(
          tableForm("seatNumber"),
          options = options("2"->"2","6"->"6", "9"->"9", "10"->"10")))),format.raw/*49.70*/("""
          
        <input type="submit" value="Create">
        
    """)))})),format.raw/*53.6*/("""
    
""")))})),format.raw/*55.2*/("""
"""))}
    }
    
    def render(tables:List[PokerTable],tableForm:Form[Tables.Table]): play.api.templates.HtmlFormat.Appendable = apply(tables,tableForm)
    
    def f:((List[PokerTable],Form[Tables.Table]) => play.api.templates.HtmlFormat.Appendable) = (tables,tableForm) => apply(tables,tableForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 22:47:49 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/tables.scala.html
                    HASH: 447dfb001bbabbc9d44bdfd134c4d885473f5fc6
                    MATRIX: 804->1|971->58|999->77|1035->79|1070->106|1109->108|1305->268|1341->288|1381->290|1449->322|1464->328|1520->362|1559->365|1573->370|1605->380|1663->402|1677->407|1714->422|1768->440|1782->445|1820->461|1874->479|1888->484|1926->500|1997->535|2054->583|2094->585|2201->660|2276->703|2363->755|2401->784|2441->786|2511->820|2529->829|2571->849|2615->862|2657->869|2696->899|2736->901|2791->920|2841->948|2881->953|3020->1070|3059->1074|3228->1221|3267->1225|3410->1346|3512->1417|3550->1424
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|52->24|55->27|60->32|60->32|60->32|62->34|62->34|62->34|64->36|66->38|66->38|66->38|68->40|68->40|69->41|71->43|72->44|74->46|75->47|77->49|81->53|83->55
                    -- GENERATED --
                */
            