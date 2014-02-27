
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
object createAccount extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Account],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(accountForm: Form[Application.Account]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Poker Game - Create Account")/*5.37*/ {_display_(Seq[Any](format.raw/*5.39*/("""

	"""),_display_(Seq[Any](/*7.3*/form(routes.Application.submitAccount())/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""

		<h1>Create a new account</h1>

		"""),_display_(Seq[Any](/*11.4*/if(accountForm.hasGlobalErrors)/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
		    <p class="error">
		        """),_display_(Seq[Any](/*13.12*/accountForm/*13.23*/.globalError.message)),format.raw/*13.43*/("""
		    </p>
		""")))})),format.raw/*15.4*/("""

		<p>
			<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*18.65*/accountForm("email")/*18.85*/.value)),format.raw/*18.91*/("""">
		</p>
		<p>
			<input type="email" name="confirmEmail" placeholder="ConfirmEmail">
		</p>
		<p>
			<input type="password" name="password" placeholder="Password">
		</p>
		<p>
			<input type="password" name="confirmPassword" placeholder="ConfirmPassword">
		</p>
		<p>
			<input type="submit" value="Create"/>
		</p>
	""")))})),format.raw/*32.3*/("""
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(accountForm:Form[Application.Account]): play.api.templates.HtmlFormat.Appendable = apply(accountForm)
    
    def f:((Form[Application.Account]) => play.api.templates.HtmlFormat.Appendable) = (accountForm) => apply(accountForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 22:22:56 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/createAccount.scala.html
                    HASH: 0d1bd40106497b7ffec5c1279c890219b8dd47f1
                    MATRIX: 801->1|951->41|979->60|1015->62|1058->97|1097->99|1135->103|1183->143|1222->145|1295->183|1335->214|1375->216|1447->252|1467->263|1509->283|1555->298|1663->370|1692->390|1720->396|2073->718|2106->720
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|41->13|43->15|46->18|46->18|46->18|60->32|61->33
                    -- GENERATED --
                */
            