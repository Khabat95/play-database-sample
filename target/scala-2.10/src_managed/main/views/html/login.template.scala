
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm: Form[Application.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Poker Game - Login")/*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""

 	<div id="signIn" style="float:left; margin:0; width:50%;">
	"""),_display_(Seq[Any](/*8.3*/form(routes.Application.authenticate())/*8.42*/ {_display_(Seq[Any](format.raw/*8.44*/("""

		<h1>Sign in</h1>

		"""),_display_(Seq[Any](/*12.4*/if(loginForm.hasGlobalErrors)/*12.33*/ {_display_(Seq[Any](format.raw/*12.35*/("""
		    <p class="error">
		        """),_display_(Seq[Any](/*14.12*/loginForm/*14.21*/.globalError.message)),format.raw/*14.41*/("""
		    </p>
		""")))})),format.raw/*16.4*/("""

		<p>
			<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*19.65*/loginForm("email")/*19.83*/.value)),format.raw/*19.89*/("""">
		</p>
		<p>
			<input type="password" name="password" placeholder="Password">
		</p>
		<p>
			<input type="submit" value="Login"/>
		</p>
	""")))})),format.raw/*27.3*/("""
	</div>
 	<div id="createAccount" style="float:left; margin:0; width:50%;">
		<h1>Don't have an account?</h1>
		<a href=""""),_display_(Seq[Any](/*31.13*/routes/*31.19*/.Application.createAccount)),format.raw/*31.45*/("""">Create an account</a>
	</div>
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(loginForm:Form[Application.Login]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)
    
    def f:((Form[Application.Login]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 22:22:56 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/login.scala.html
                    HASH: 517b29febb7dc192fb15b25f82b0b8ac24b5e9d0
                    MATRIX: 791->1|937->37|965->56|1001->58|1035->84|1074->86|1173->151|1220->190|1259->192|1319->217|1357->246|1397->248|1469->284|1487->293|1529->313|1575->328|1683->400|1710->418|1738->424|1913->568|2072->691|2087->697|2135->723|2199->756
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|36->8|40->12|40->12|40->12|42->14|42->14|42->14|44->16|47->19|47->19|47->19|55->27|59->31|59->31|59->31|61->33
                    -- GENERATED --
                */
            