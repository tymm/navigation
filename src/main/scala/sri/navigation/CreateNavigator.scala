package sri.navigation

import sri.core.ReactElement
import sri.navigation.navigators.NavigationNavigatorConstructor

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("react-navigation", "createNavigator")
@js.native
object CreateNavigator extends js.Object {
  type NavigatorView =
    js.Function1[NavigatorScreenProps[_], ReactElement]
  def apply(router: NavigationRouter)
    : js.Function1[NavigatorView, NavigationNavigatorConstructor] = js.native
}
