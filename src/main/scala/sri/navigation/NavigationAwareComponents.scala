package sri.navigation

import sri.core.{
  =:!=,
  Component,
  ComponentJS,
  ComponentNoPS,
  ComponentP,
  ComponentS,
  ReactClass,
  ReactJSProps
}

import scala.language.existentials
import scala.reflect.ClassTag
import scala.scalajs.js
import scala.scalajs.js.ConstructorTag
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
trait ScreenClass extends ReactClass {
  type ParamsType <: js.Object
}

@ScalaJSDefined
abstract class NavigationScreenComponentP[P >: Null <: js.Object](
    implicit ev: =:!=[P, Null])
    extends NavigationScreenComponent[P, Null] {}

@ScalaJSDefined
abstract class NavigationScreenComponentNoPS
    extends NavigationScreenComponent[Null, Null]

@ScalaJSDefined
abstract class NavigationScreenComponentS[S <: AnyRef](
    implicit ev: =:!=[S, Null])
    extends NavigationScreenComponent[Null, S]

@ScalaJSDefined
abstract class NavigationScreenComponent[Params >: Nothing <: js.Object,
S <: AnyRef](implicit ev: =:!=[Params, Nothing])
    extends ComponentJS[NavigatorScreenProps[Params], S]
    with ScreenClass {

  override type ParamsType = Params

  implicit def navigationJS = props.navigation
  def navigation = NavigationCtrl

  @inline
  def params: js.UndefOr[ParamsType] = props.navigation.state.params

  @inline
  def setParams(params: ParamsType) = props.navigation.setParams(params)

}

object NavigationCtrl {

  type NV = Navigation[_]

  @inline
  def navigate[C <: NavigationScreenComponent[Null, _]: ConstructorTag](
      implicit ctag: ClassTag[C],
      navigation: NV) =
    navigation.navigate(ctag.runtimeClass.getName)

  @inline
  def navigate[C <: ScreenClass: ConstructorTag](
      params: C#ParamsType)(implicit ctag: ClassTag[C], navigation: NV) =
    navigation
      .navigate(ctag.runtimeClass.getName, params)
  @inline
  def goBack(routeKey: String)(implicit navigation: NV) =
    navigation.goBack(routeKey)

  @inline
  def goBack()(implicit navigation: NV) = navigation.goBack()

  @inline
  def openDrawer()(implicit navigation: NV) = navigation.navigate(DRAWER_OPEN)

  @inline
  def closeDrawer()(implicit navigation: NV) =
    navigation.navigate(DRAWER_CLOSE)

}
@ScalaJSDefined
abstract class NavigationAwareComponent[P >: Null <: AnyRef,
                                        S >: Null <: AnyRef](
    implicit ev: =:!=[P, Null],
    ev2: =:!=[S, Null])
    extends Component[P, S] {

  @inline
  implicit def navigationJS = context.navigation.asInstanceOf[Navigation[_]]

  @inline
  def navigation = NavigationCtrl
}

@ScalaJSDefined
abstract class NavigationAwareComponentP[P >: Null <: AnyRef](
    implicit ev: =:!=[P, Null])
    extends ComponentP[P] {

  @inline
  implicit def navigationJS = context.navigation.asInstanceOf[Navigation[_]]

  @inline
  def navigation = NavigationCtrl
}

@ScalaJSDefined
abstract class NavigationAwareComponentS[S >: Null <: AnyRef](
    implicit ev: =:!=[S, Null])
    extends ComponentS[S] {

  @inline
  implicit def navigationJS = context.navigation.asInstanceOf[Navigation[_]]

  @inline
  def navigation = NavigationCtrl
}

@ScalaJSDefined
abstract class NavigationAwareComponentNoPS extends ComponentNoPS {

  @inline
  implicit def navigationJS = context.navigation.asInstanceOf[Navigation[_]]

  @inline
  def navigation = NavigationCtrl
}

//object NavigationAwareComponent {
//  @JSExportStatic
//  val contextTypes =
//    js.Dictionary("navigation" -> React.PropTypes.`object`.isRequired)
//
//}
