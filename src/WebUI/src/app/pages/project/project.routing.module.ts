import {NgModule} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {ProjectComponent} from "./project.component";

const routes: Routes = [ //localhost/issue/ diye bir alana geldiyse artik bunun altindaki routingler burada olcak
  {
    path: '',
    component: ProjectComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export  class ProjectRoutingModule{

}
