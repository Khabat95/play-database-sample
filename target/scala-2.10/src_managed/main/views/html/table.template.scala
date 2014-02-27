
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
object table extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[PokerTable,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(table: PokerTable):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.21*/("""


"""),_display_(Seq[Any](/*4.2*/main("Poker Game - Table " + table.getName())/*4.47*/ {_display_(Seq[Any](format.raw/*4.49*/("""
	<h1>"""),_display_(Seq[Any](/*5.7*/table/*5.12*/.getName())),format.raw/*5.22*/("""</h1>

	<ul>
		<li>
			"""),_display_(Seq[Any](/*9.5*/table/*9.10*/.getTableType().toString())),format.raw/*9.36*/("""
		</li>
		<li>
			"""),_display_(Seq[Any](/*12.5*/table/*12.10*/.getTableLimit().toString())),format.raw/*12.37*/("""
		</li>
		<li>
			"""),_display_(Seq[Any](/*15.5*/table/*15.10*/.getSeatNumber())),format.raw/*15.26*/(""" seats
		</li>
	</ul>	
""")))})),format.raw/*18.2*/("""
"""))}
    }
    
    def render(table:PokerTable): play.api.templates.HtmlFormat.Appendable = apply(table)
    
    def f:((PokerTable) => play.api.templates.HtmlFormat.Appendable) = (table) => apply(table)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 22:39:35 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/table.scala.html
                    HASH: bf9f3c63a051c5de83e656e498e03b527275409c
                    MATRIX: 778->1|891->20|929->24|982->69|1021->71|1062->78|1075->83|1106->93|1164->117|1177->122|1224->148|1279->168|1293->173|1342->200|1397->220|1411->225|1449->241|1504->265
                    LINES: 26->1|29->1|32->4|32->4|32->4|33->5|33->5|33->5|37->9|37->9|37->9|40->12|40->12|40->12|43->15|43->15|43->15|46->18
                    -- GENERATED --
                */
            