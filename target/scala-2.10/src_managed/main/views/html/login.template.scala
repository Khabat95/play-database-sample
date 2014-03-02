
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[dto.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm: Form[dto.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Poker Game - Login")/*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""

	<div id="signIn" style="float: left; margin: 0; width: 50%;">
	
		"""),_display_(Seq[Any](/*9.4*/form(routes.Application.authenticate())/*9.43*/ {_display_(Seq[Any](format.raw/*9.45*/("""
	
			<h1>Sign in</h1>
		
			"""),_display_(Seq[Any](/*13.5*/if(loginForm.hasGlobalErrors)/*13.34*/ {_display_(Seq[Any](format.raw/*13.36*/("""
				<p class="error">"""),_display_(Seq[Any](/*14.23*/loginForm/*14.32*/.globalError.message)),format.raw/*14.52*/("""</p>
			""")))})),format.raw/*15.5*/("""
		
			<p>
				<input type="email" name="email" placeholder="Email"
					value=""""),_display_(Seq[Any](/*19.14*/loginForm("email")/*19.32*/.value)),format.raw/*19.38*/("""">
			</p>
			<p>
				<input type="password" name="password" placeholder="Password">
			</p>
			<p>
				<input type="submit" value="Login" />
			</p>
		""")))})),format.raw/*27.4*/("""
	</div>
	<div id="createAccount" style="float: left; margin: 0; width: 50%;">
		<h1>Don't have an account?</h1>
		<a href=""""),_display_(Seq[Any](/*31.13*/routes/*31.19*/.Application.createAccount)),format.raw/*31.45*/("""">Create an account</a>
	</div>
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(loginForm:Form[dto.Login]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)
    
    def f:((Form[dto.Login]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 14:15:19 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/login.scala.html
                    HASH: f9f5af0c45ea1937d208a677ad6a1347112ee686
                    MATRIX: 783->1|921->29|949->48|985->50|1019->76|1058->78|1162->148|1209->187|1248->189|1313->219|1351->248|1391->250|1450->273|1468->282|1510->302|1550->311|1667->392|1694->410|1722->416|1906->569|2067->694|2082->700|2130->726|2194->759
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|41->13|41->13|41->13|42->14|42->14|42->14|43->15|47->19|47->19|47->19|55->27|59->31|59->31|59->31|61->33
                    -- GENERATED --
                */
            