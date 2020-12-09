import {NgModule} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {IssueComponent} from "./issue.component";

const routes: Routes = [ //localhost/issue/ diye bir alana geldiyse artik bunun altindaki routingler burada olcak
  {
    path: '',
    component: IssueComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export  class IssueRoutingModule{

}
