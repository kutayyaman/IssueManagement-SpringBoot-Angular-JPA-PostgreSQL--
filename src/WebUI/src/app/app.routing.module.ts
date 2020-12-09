import {NgModule} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import {IssueComponent} from "./pages/issue/issue.component";
import {ProjectComponent} from "./pages/project/project.component";

const routes: Routes = [
  {path: '',   redirectTo: '/dashboard', pathMatch: 'full'},
  {path : 'dashboard' , component : DashboardComponent },
  {path : 'issue' , component : IssueComponent },
  {path : 'project' , component : ProjectComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export  class AppRoutingModule{

}
