package sri.navigation

import sri.core.{CreateElementJS, JSComponent, ReactClass}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-navigation", "DrawerView.Items")
object DrawerViewItemsComponent extends JSComponent[js.Object]

object DrawerViewItems {
  @inline
  def apply(props: Navigation[_]) =
    CreateElementJS[DrawerViewItemsComponent.type](DrawerViewItemsComponent,
                                                   props)
}
