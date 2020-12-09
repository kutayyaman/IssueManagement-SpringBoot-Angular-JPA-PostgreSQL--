import {NgModule} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./dashboard.component";

const routes: Routes = [ //localhost/issue/ diye bir alana geldiyse artik bunun altindaki routingler burada olcak
  {
    path: '',
    component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export  class DashboardRoutingModule{

}
