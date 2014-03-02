
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
object createAccount extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[dto.Account],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(accountForm: Form[dto.Account]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Poker Game - Create Account")/*5.37*/ {_display_(Seq[Any](format.raw/*5.39*/("""

	"""),_display_(Seq[Any](/*7.3*/form(routes.Application.submitAccount())/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""

		<h1>Create a new account</h1>
		
		"""),_display_(Seq[Any](/*11.4*/if(accountForm.hasGlobalErrors)/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
			<p class="error">"""),_display_(Seq[Any](/*12.22*/accountForm/*12.33*/.globalError.message)),format.raw/*12.53*/("""</p>
		""")))})),format.raw/*13.4*/("""
		
		<p>
			<input type="email" name="email" placeholder="Email"
				value=""""),_display_(Seq[Any](/*17.13*/accountForm("email")/*17.33*/.value)),format.raw/*17.39*/("""">
		</p>
		<p>
			<input type="email" name="confirmEmail" placeholder="ConfirmEmail"
				value=""""),_display_(Seq[Any](/*21.13*/accountForm("confirmEmail")/*21.40*/.value)),format.raw/*21.46*/("""">
		</p>
		<p>
			<input type="password" name="password" placeholder="Password">
		</p>
		<p>
			<input type="password" name="confirmPassword"
				placeholder="ConfirmPassword">
		</p>
		<p>
			<input type="submit" value="Create" />
		</p>
	""")))})),format.raw/*33.3*/("""
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(accountForm:Form[dto.Account]): play.api.templates.HtmlFormat.Appendable = apply(accountForm)
    
    def f:((Form[dto.Account]) => play.api.templates.HtmlFormat.Appendable) = (accountForm) => apply(accountForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 14:15:18 EST 2014
                    SOURCE: /home/khabat95/workspace/database-sample/app/views/createAccount.scala.html
                    HASH: aeb51ff44de6ea13442d348f029f681604bf1b82
                    MATRIX: 793->1|935->33|963->52|999->54|1042->89|1081->91|1119->95|1167->135|1206->137|1281->177|1321->208|1361->210|1419->232|1439->243|1481->263|1520->271|1634->349|1663->369|1691->375|1825->473|1861->500|1889->506|2163->749|2196->751
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|40->12|40->12|40->12|41->13|45->17|45->17|45->17|49->21|49->21|49->21|61->33|62->34
                    -- GENERATED --
                */
            