
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
object table extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[dto.PokerTable,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(table: dto.PokerTable):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""

"""),_display_(Seq[Any](/*3.2*/main("Poker Game - Table " + table.getName())/*3.47*/ {_display_(Seq[Any](format.raw/*3.49*/("""

	<h1>"""),_display_(Seq[Any](/*5.7*/table/*5.12*/.getName())),format.raw/*5.22*/("""</h1>
	
	<ul>
		<li>"""),_display_(Seq[Any](/*8.8*/table/*8.13*/.getTableType().toString())),format.raw/*8.39*/("""</li>
		<li>"""),_display_(Seq[Any](/*9.8*/table/*9.13*/.getTableLimit().toString())),format.raw/*9.40*/("""</li>
		<li>"""),_display_(Seq[Any](/*10.8*/table/*10.13*/.getSeatNumber())),format.raw/*10.29*/(""" seats</li>
	</ul>

""")))})),format.raw/*13.2*/("""
"""))}
    }
    
    def render(table:dto.PokerTable): play.api.templates.HtmlFormat.Appendable = apply(table)
    
    def f:((dto.PokerTable) => play.api.templates.HtmlFormat.Appendable) = (table) => apply(table)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 14:15:18 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/table.scala.html
                    HASH: 00787ecbdf5ff9018ee8d322e6ce56f96b3693cc
                    MATRIX: 782->1|899->24|936->27|989->72|1028->74|1070->82|1083->87|1114->97|1169->118|1182->123|1229->149|1276->162|1289->167|1337->194|1385->207|1399->212|1437->228|1489->249
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13
                    -- GENERATED --
                */
            