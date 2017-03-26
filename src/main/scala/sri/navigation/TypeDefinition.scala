package sri.navigation

import sri.core.{ReactClass, ReactElement, ReactJSProps}
import sri.macros.{FunctionObjectMacro, OptDefault, OptionalParam}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{undefined, |, UndefOr => U}

@ScalaJSDefined
trait NavigationState extends js.Object {
  val index: Double
  val routes: js.Array[NavigationRoute[js.Object]]
}

@ScalaJSDefined
trait RouteBase extends js.Object {
  type ParamsType <: js.Object
}

@ScalaJSDefined
trait NavigationRoute[Params <: js.Object] extends RouteBase {
  override type ParamsType = Params
  val key: String
  val routeName: String
  val path: U[String] = undefined
  val params: U[Params] = undefined
}

object NavigationRoute {
  @inline
  def apply[Params <: js.Object](key: String,
                                 routeName: String,
                                 path: OptionalParam[String] = OptDefault,
                                 params: OptionalParam[Params] = OptDefault,
                                 index: Double,
                                 routes: js.Array[NavigationRoute[js.Object]])
    : NavigationRoute[Params] = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationRoute[Params]]
  }
}

@ScalaJSDefined
trait NavigationRouter extends js.Object {
  val getStateForAction: js.Function2[NavigationAction /*action*/,
                                      U[NavigationState] /*lastState*/,
                                      U[NavigationState]]
  val getActionForPathAndParams: js.Function2[String /*path*/,
                                              U[NavigationParams] /*params*/,
                                              U[NavigationAction]]
  val getPathAndParamsForState: js.Function1[NavigationState /*state*/,
                                             js.Object]
  val getComponentForRouteName: js.Function1[String /*routeName*/,
                                             NavigationComponent]
  val getComponentForState: js.Function1[NavigationState /*state*/,
                                         NavigationComponent]
  val getScreenConfig: js.Function2[
    NavigationScreenProp[NavigationRoute[js.Object]] /*navigation*/,
    String /*optionName*/,
    U[js.Any]]

}

@ScalaJSDefined
trait HeaderConfig extends js.Object {
  val title: U[String | ReactElement] = undefined
  val visible: U[Boolean] = undefined
  val tintColor: U[String] = undefined
  val backTitle: U[String] = undefined
  val right: U[ReactElement] = undefined
  val left: U[ReactElement] = undefined
  val style: U[js.Any] = undefined
  val titleStyle: U[js.Any] = undefined
}

object HeaderConfig {
  import sri.universal.DangerousUnionToJSAnyImplicit._
  @inline
  def apply(title: OptionalParam[String | ReactElement] = OptDefault,
            visible: OptionalParam[Boolean] = OptDefault,
            tintColor: OptionalParam[String] = OptDefault,
            titleStyle: OptionalParam[js.Any] = OptDefault,
            backTitle: OptionalParam[String] = OptDefault,
            right: OptionalParam[ReactElement] = OptDefault,
            left: OptionalParam[ReactElement] = OptDefault,
            style: OptionalParam[js.Any] = OptDefault): HeaderConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[HeaderConfig]
  }
}

@ScalaJSDefined
trait IconOptions extends js.Object {

  val tintColor: String

  val focused: Boolean
}

object TabBarConfig {
  @inline
  def apply(icon: OptionalParam[IconOptions => ReactElement] = OptDefault,
            label: OptionalParam[String] = OptDefault): TabBarConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[TabBarConfig]
  }
}

@ScalaJSDefined
trait TabBarConfig extends js.Object {
  val icon: U[js.Function1[IconOptions, U[ReactElement]]] =
    undefined
  val label: U[String] = undefined
}

object DrawerConfig {
  @inline
  def apply(icon: OptionalParam[IconOptions => ReactElement] = OptDefault,
            label: OptionalParam[String] = OptDefault): DrawerConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[DrawerConfig]
  }
}

@ScalaJSDefined
trait DrawerConfig extends js.Object {
  val icon: U[js.Function1[IconOptions, U[ReactElement]]] =
    undefined
  val label: U[String] = undefined
}

object NavigationScreenOptionsImplicits {
  implicit def ftoJSF1[T <: js.Object, R](
      in: scala.Function1[NavigationScreenProp[T], R])
    : OptionalParam[NavigationScreenOption[R, T]] = {
    in: js.Function1[NavigationScreenProp[T], R]
  }

  implicit def ftoJSF12[T <: js.Object, R](
      in: scala.Function2[NavigationScreenProp[T], js.Object, R])
    : OptionalParam[NavigationScreenOption[R, T]] = {
    in: js.Function2[NavigationScreenProp[T], js.Object, R]
  }

  implicit def ftoJSF123[T <: js.Object, R](
      in: scala.Function3[NavigationScreenProp[T],
                          js.Object,
                          U[NavigationRouter],
                          R]): OptionalParam[NavigationScreenOption[R, T]] = {
    in: js.Function3[NavigationScreenProp[T],
                     js.Object,
                     U[NavigationRouter],
                     R]
  }
}

@ScalaJSDefined
trait NavigationScreenOptions extends js.Object {
  type Screen <: ScreenClass
  val title: U[NavigationScreenOption[String, Screen#ParamsType]] = undefined
  val header: U[NavigationScreenOption[HeaderConfig, Screen#ParamsType]] =
    undefined
  val tabBar: U[NavigationScreenOption[TabBarConfig, Screen#ParamsType]] =
    undefined
  val drawer: U[NavigationScreenOption[DrawerConfig, Screen#ParamsType]] =
    undefined
}

@ScalaJSDefined
trait GenericScreen extends ScreenClass {
  override type ParamsType = js.Object
}

object NavigationScreenOptions {
  import sri.universal.DangerousUnionToJSAnyImplicit._

  @inline
  def apply[S <: ScreenClass](
      title: OptionalParam[NavigationScreenOption[String, S#ParamsType]] =
        OptDefault,
      header: OptionalParam[NavigationScreenOption[HeaderConfig, S#ParamsType]] =
        OptDefault,
      tabBar: OptionalParam[NavigationScreenOption[TabBarConfig, S#ParamsType]] =
        OptDefault,
      drawer: OptionalParam[NavigationScreenOption[DrawerConfig, S#ParamsType]] =
        OptDefault): NavigationScreenOptions { type Screen = S } = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationScreenOptions { type Screen = S }]
  }
}

@ScalaJSDefined
trait NavigationScreenConfig extends js.Object {
  val title: U[String] = undefined
  val header: U[HeaderConfig] = undefined
  val tabBar: U[TabBarConfig] = undefined
  val drawer: U[DrawerConfig] = undefined
}

object NavigationScreenConfig {
  @inline
  def apply(title: OptionalParam[String] = OptDefault,
            header: OptionalParam[HeaderConfig] = OptDefault,
            tabBar: OptionalParam[TabBarConfig] = OptDefault,
            drawer: OptionalParam[DrawerConfig] = OptDefault)
    : NavigationScreenConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationScreenConfig]
  }
}

//@ScalaJSDefined
//trait NavigationScreenComponent[T] extends js.Object {}

@ScalaJSDefined
trait NavigationNavigator[T] extends js.Object {}

@ScalaJSDefined
trait NavigationParams extends js.Object

@ScalaJSDefined
trait NavigationNavigateAction extends js.Object {
  var `type`: String
  var routeName: String
  var params: U[NavigationParams] = undefined
  var action: U[NavigationNavigateAction] = undefined
}

object NavigationNavigateAction {

  def apply(routeName: String,
            params: U[NavigationParams] = undefined,
            action: U[NavigationNavigateAction] = undefined) =
    literal(`type` = "Navigate",
            routeName = routeName,
            params = params,
            action = action).asInstanceOf[NavigationNavigateAction]
}

@ScalaJSDefined
trait NavigationBackAction extends js.Object {
  var `type`: String
  var key: U[String] = undefined
}

object NavigationBackAction {

  def apply(key: U[String] = undefined) =
    literal(`type` = "Back", key = key).asInstanceOf[NavigationBackAction]
}

@ScalaJSDefined
trait NavigationSetParamsAction extends js.Object {
  var `type`: String
  var key: String
  var params: U[NavigationParams] = undefined
}

object NavigationSetParamsAction {
  def apply(key: String, params: U[NavigationParams] = undefined) =
    literal(`type` = "SetParams", key = key, params = params)
      .asInstanceOf[NavigationSetParamsAction]
}

@ScalaJSDefined
trait NavigationInitAction extends js.Object {
  var `type`: String
}

object NavigationInitAction {
  def apply() = literal(`type` = "Init").asInstanceOf[NavigationInitAction]
}

@ScalaJSDefined
trait NavigationResetAction extends js.Object {
  var `type`: String
  var index: Double
  var actions: js.Array[NavigationNavigateAction]
}

object NavigationResetAction {
  def apply(index: Double, actions: js.Array[NavigationNavigateAction]) =
    literal(`type` = "Reset", index = index, actions = actions)
      .asInstanceOf[NavigationResetAction]
}

@ScalaJSDefined
trait NavigationContainerOptions extends js.Object {
  val URIPrefix: U[String] = undefined
}

object NavigationContainerOptions {
  @inline
  def apply(URIPrefix: OptionalParam[String] = OptDefault)
    : NavigationContainerOptions = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationContainerOptions]
  }
}

@ScalaJSDefined
trait NavigationContainerConfig extends js.Object {
  val containerOptions: U[NavigationContainerOptions] = undefined
}

object NavigationContainerConfig {
  @inline
  def apply(
      containerOptions: OptionalParam[NavigationContainerOptions] = OptDefault)
    : NavigationContainerConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationContainerConfig]
  }
}

@ScalaJSDefined
trait NavigationStackViewConfigMode extends js.Object

object NavigationStackViewConfigMode {
  @inline def CARD = "card".asInstanceOf[NavigationStackViewConfigMode]
  @inline def MODAL = "modal".asInstanceOf[NavigationStackViewConfigMode]
}

@ScalaJSDefined
trait HeaderMode extends js.Object

object HeaderMode {
  @inline def FLOAT = "float".asInstanceOf[HeaderMode]
  @inline def SCREEN = "screen".asInstanceOf[HeaderMode]
  @inline def NONE = "none".asInstanceOf[HeaderMode]
}

@ScalaJSDefined
trait NavigationStackViewConfig extends js.Object {
  val mode: U[NavigationStackViewConfigMode] = undefined

  val headerMode: U[HeaderMode] = undefined
  val cardStyle: U[js.Any] = undefined
  val onTransitionStart: U[js.Function0[_]] = undefined
  val onTransitionEnd: U[js.Function0[_]] = undefined
  val headerComponent: U[js.Object] = undefined
}

object NavigationStackViewConfig {
  @inline
  def apply(mode: OptionalParam[NavigationStackViewConfigMode] = OptDefault,
            headerMode: OptionalParam[HeaderMode] = OptDefault,
            headerComponent: OptionalParam[js.Object] = OptDefault)
    : NavigationStackViewConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationStackViewConfig]
  }
}

@ScalaJSDefined
trait NavigationStackRouterConfig extends js.Object {
  val initialRouteName: U[String] = undefined
  val initialRouteParams: U[NavigationParams] = undefined
  val paths: U[NavigationPathsConfig] = undefined
  val navigationOptions: U[NavigationScreenOptions] = undefined
}

object NavigationStackRouterConfig {
  @inline
  def apply(initialRouteName: OptionalParam[String] = OptDefault,
            initialRouteParams: OptionalParam[NavigationParams] = OptDefault,
            paths: OptionalParam[NavigationPathsConfig] = OptDefault,
            navigationOptions: OptionalParam[NavigationScreenOptions] =
              OptDefault): NavigationStackRouterConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationStackRouterConfig]
  }
}

@ScalaJSDefined
trait NavigationScreenRouteConfig extends js.Object {
  var screen: js.Any //TODO fix this
  var navigationOptions: U[NavigationScreenOptions] = undefined
  var path: U[String] = undefined
}

object NavigationScreenRouteConfig {
  @inline
  def apply(screen: js.Any,
            path: OptionalParam[String] = OptDefault,
            navigationOptions: OptionalParam[NavigationScreenOptions])
    : NavigationScreenRouteConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationScreenRouteConfig]
  }
}

@ScalaJSDefined
trait NavigationScreenRouteConfigVal extends js.Object {
  val screen: NavigationScreenComponent[_, _] | NavigationNavigator[_]
  val navigationOptions: U[NavigationScreenOptions] = undefined
  val path: U[String] = undefined
}

@ScalaJSDefined
trait NavigationLazyScreenRouteConfig extends js.Object {
  val getScreen: js.Function0[NavigationScreenComponent[_, _]] | NavigationNavigator[
    _]
  val navigationOptions: U[NavigationScreenOptions] = undefined
  val path: U[String] = undefined
}

object NavigationLazyScreenRouteConfig {
  import sri.universal.DangerousUnionToJSAnyImplicit._
  @inline
  def apply(
      getScreen: js.Function0[NavigationScreenComponent[_, _]] | NavigationNavigator[
        _],
      navigationOptions: OptionalParam[NavigationScreenOptions] = OptDefault,
      path: OptionalParam[String] = OptDefault)
    : NavigationLazyScreenRouteConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationLazyScreenRouteConfig]
  }
}
@ScalaJSDefined
trait NavigationTabRouterConfig extends js.Object {
  val initialRouteName: U[String] = undefined
  val paths: U[NavigationPathsConfig] = undefined
  val navigationOptions: U[NavigationScreenOptions] = undefined
  val order: U[js.Array[String]] = undefined
}

object NavigationTabRouterConfig {
  @inline
  def apply(initialRouteName: OptionalParam[String] = OptDefault,
            paths: OptionalParam[NavigationPathsConfig] = OptDefault,
            navigationOptions: OptionalParam[NavigationScreenOptions] =
              OptDefault,
            order: OptionalParam[js.Array[String]] = OptDefault)
    : NavigationTabRouterConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationTabRouterConfig]
  }
}

@ScalaJSDefined
trait NavigationProp[S] extends js.Object {
  val state: S
  val dispatch: NavigationDispatch[NavigationAction]
}

@js.native
trait NavigatorScreenProps[P <: js.Object] extends ReactJSProps {
  val navigation: NavigationScreenProp[P] = js.native
}

@js.native
trait NavigationScreenProp[P <: js.Object] extends js.Object {
  val state: NavigationRoute[P] = js.native
  val dispatch: NavigationDispatch[NavigationAction] = js.native
  def goBack(routeKey: String = ???): Boolean =
    js.native
  def navigate(routeName: String,
               params: Any = ???,
               action: NavigationAction = ???): Boolean = js.native
  def setParams(newParams: P): Boolean = js.native
}

@ScalaJSDefined
trait NavigationNavigatorProps extends js.Object {
  val navigation: NavigationProp[NavigationState]
  val router: NavigationRouter
}

@ScalaJSDefined
trait NavigationLayout extends js.Object {
  val height: NavigationAnimatedValue
  val initHeight: Double
  val initWidth: Double
  val isMeasured: Boolean
  val width: NavigationAnimatedValue
}

@ScalaJSDefined
trait NavigationScene extends js.Object {
  val index: Double
  val isActive: Boolean
  val isStale: Boolean
  val key: String
  val route: NavigationRoute[js.Object]
}

@ScalaJSDefined
trait NavigationTransitionProps extends js.Object {
  val layout: NavigationLayout
  val navigationState: NavigationState
  val position: NavigationAnimatedValue
  val progress: NavigationAnimatedValue
  val scenes: js.Array[NavigationScene]
  val scene: NavigationScene
  val index: Double
  val gestureResponseDistance: U[Double] = undefined
}

@ScalaJSDefined
trait NavigationPanHandlers extends js.Object {
  val onMoveShouldSetResponder: js.Function0[Unit]
  val onMoveShouldSetResponderCapture: js.Function0[Unit]
  val onResponderEnd: js.Function0[Unit]
  val onResponderGrant: js.Function0[Unit]
  val onResponderMove: js.Function0[Unit]
  val onResponderReject: js.Function0[Unit]
  val onResponderRelease: js.Function0[Unit]
  val onResponderStart: js.Function0[Unit]
  val onResponderTerminate: js.Function0[Unit]
  val onResponderTerminationRequest: js.Function0[Unit]
  val onStartShouldSetResponder: js.Function0[Unit]
  val onStartShouldSetResponderCapture: js.Function0[Unit]
}

@ScalaJSDefined
trait NavigationTransitionSpec extends js.Object {
  val duration: U[Double] = undefined
  val easing: U[js.Function0[js.Any]] = undefined
  val timing: U[js.Function2[NavigationAnimatedValue /*value*/,
                             js.Any /*config*/,
                             js.Any]] = undefined
}

object NavigationTransitionSpec {
  @inline
  def apply(
      duration: OptionalParam[Double] = OptDefault,
      easing: OptionalParam[js.Function0[js.Any]] = OptDefault,
      timing: OptionalParam[
        (NavigationAnimatedValue /*value*/, js.Any /*config*/ ) => js.Any] =
        OptDefault): NavigationTransitionSpec = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[NavigationTransitionSpec]
  }
}

@ScalaJSDefined
trait NavigationGestureDirection extends js.Object

object NavigationGestureDirection {
  @inline def HORIZONTAL =
    "horizontal".asInstanceOf[NavigationGestureDirection]
  @inline def VERTICAL = "vertical".asInstanceOf[NavigationGestureDirection]

}

@ScalaJSDefined
trait TabBarPosition extends js.Object

object TabBarPosition {
  @inline def TOP = "top".asInstanceOf[TabBarPosition]
  @inline def BOTTOM = "bottom".asInstanceOf[TabBarPosition]
}

@ScalaJSDefined
trait TabBarOptions extends js.Object {
  val activeTintColor: U[String] = undefined
  val showIcon: U[Boolean] = undefined
}

object TabBarOptions {
  @inline
  def apply(activeTintColor: OptionalParam[String] = OptDefault,
            showIcon: OptionalParam[Boolean] = OptDefault): TabBarOptions = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[TabBarOptions]
  }
}
@ScalaJSDefined
trait TabViewConfig extends js.Object {
  val tabBarComponent: U[ReactClass] = undefined
  val tabBarPosition: U[TabBarPosition] = undefined
  val tabBarOptions: U[js.Object] = undefined
  val swipeEnabled: U[Boolean] = undefined
  val animationEnabled: U[Boolean] = undefined
  val lazyLoad: U[Boolean] = undefined
}

object TabViewConfig {
  @inline
  def apply(tabBarComponent: OptionalParam[ReactClass] = OptDefault,
            tabBarPosition: OptionalParam[TabBarPosition] = OptDefault,
            tabBarOptions: OptionalParam[js.Object] = OptDefault,
            swipeEnabled: OptionalParam[Boolean] = OptDefault,
            animationEnabled: OptionalParam[Boolean] = OptDefault,
            lazyLoad: OptionalParam[Boolean] = OptDefault): TabViewConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[TabViewConfig]
  }
}

@ScalaJSDefined
trait DrawerPosition extends js.Object

object DrawerPosition {

  @inline def LEFT = "left".asInstanceOf[DrawerPosition]
  @inline def RIGHT = "right".asInstanceOf[DrawerPosition]
}

@ScalaJSDefined
trait DrawerContentOptions extends js.Object {
  val activeTintColor: U[String] = undefined
  val activeBackgroundColor: U[String] = undefined
  val inactiveTintColor: U[String] = undefined
  val inactiveBackgroundColor: U[String] = undefined
  val style: U[js.Any] = undefined
}

object DrawerContentOptions {
  @inline
  def apply(
      activeTintColor: OptionalParam[String] = OptDefault,
      activeBackgroundColor: OptionalParam[String] = OptDefault,
      inactiveTintColor: OptionalParam[String] = OptDefault,
      inactiveBackgroundColor: OptionalParam[String] = OptDefault,
      style: OptionalParam[js.Any] = OptDefault): DrawerContentOptions = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[DrawerContentOptions]
  }
}

@ScalaJSDefined
trait DrawerViewConfig extends js.Object {
  val drawerWidth: U[Double] = undefined
  val drawerPosition: U[DrawerPosition] = undefined
  val contentComponent: U[ReactClass] = undefined
  val contentOptions: U[js.Object] = undefined
  val style: U[js.Any] = undefined
}

object DrawerViewConfig {
  @inline
  def apply(drawerWidth: OptionalParam[Double] = OptDefault,
            drawerPosition: OptionalParam[DrawerPosition] = OptDefault,
            contentComponent: OptionalParam[ReactClass] = OptDefault,
            contentOptions: OptionalParam[js.Object] = OptDefault,
            style: OptionalParam[js.Any] = OptDefault): DrawerViewConfig = {
    val p = FunctionObjectMacro()
    p.asInstanceOf[DrawerViewConfig]
  }
}
