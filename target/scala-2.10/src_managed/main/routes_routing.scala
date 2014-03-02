// @SOURCE:/home/khabat95/workspace/database-sample/conf/routes
// @HASH:3da3037f30ae475a692fb73a1e1322299e49b76c
// @DATE:Sun Mar 02 14:04:28 EST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:8
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_Application_createAccount3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("createAccount"))))
        

// @LINE:10
private[this] lazy val controllers_Application_submitAccount4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("createAccount"))))
        

// @LINE:11
private[this] lazy val controllers_Tables_index5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tables"))))
        

// @LINE:12
private[this] lazy val controllers_Tables_newTable6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tables"))))
        

// @LINE:13
private[this] lazy val controllers_Tables_deleteTable7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tables/"),DynamicPart("name", """[^/]+""",true),StaticPart("/delete"))))
        

// @LINE:14
private[this] lazy val controllers_Tables_openTable8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("table"))))
        

// @LINE:17
private[this] lazy val controllers_Assets_at9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""@controllers.Application@.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""@controllers.Application@.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """createAccount""","""@controllers.Application@.createAccount()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """createAccount""","""@controllers.Application@.submitAccount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tables""","""@controllers.Tables@.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tables""","""@controllers.Tables@.newTable()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tables/$name<[^/]+>/delete""","""@controllers.Tables@.deleteTable(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """table""","""@controllers.Tables@.openTable(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:8
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_Application_createAccount3(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).createAccount(), HandlerDef(this, "controllers.Application", "createAccount", Nil,"GET", """""", Routes.prefix + """createAccount"""))
   }
}
        

// @LINE:10
case controllers_Application_submitAccount4(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).submitAccount(), HandlerDef(this, "controllers.Application", "submitAccount", Nil,"POST", """""", Routes.prefix + """createAccount"""))
   }
}
        

// @LINE:11
case controllers_Tables_index5(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).index(), HandlerDef(this, "controllers.Tables", "index", Nil,"GET", """""", Routes.prefix + """tables"""))
   }
}
        

// @LINE:12
case controllers_Tables_newTable6(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).newTable(), HandlerDef(this, "controllers.Tables", "newTable", Nil,"POST", """""", Routes.prefix + """tables"""))
   }
}
        

// @LINE:13
case controllers_Tables_deleteTable7(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).deleteTable(name), HandlerDef(this, "controllers.Tables", "deleteTable", Seq(classOf[String]),"POST", """""", Routes.prefix + """tables/$name<[^/]+>/delete"""))
   }
}
        

// @LINE:14
case controllers_Tables_openTable8(params) => {
   call(params.fromQuery[String]("name", None)) { (name) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).openTable(name), HandlerDef(this, "controllers.Tables", "openTable", Seq(classOf[String]),"GET", """""", Routes.prefix + """table"""))
   }
}
        

// @LINE:17
case controllers_Assets_at9(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     