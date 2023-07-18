import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterassetComponent } from './registerasset/registerasset.component';
import { CreateticketComponent } from './createticket/createticket.component';
import { ResolveticketComponent } from './resolveticket/resolveticket.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SupportticketlistComponent } from './supportticketlist/supportticketlist.component';
import { TrackticketComponent } from './trackticket/trackticket.component';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [
  {path:'',redirectTo:'homepage',pathMatch:'full'},
  {path:'homepage',component:HomepageComponent},
  {path:'api/supportrequests/open/api/supportrequests/:id/resolve',component:ResolveticketComponent},
  {path:'api/supportrequests/open',component:SupportticketlistComponent},
  {path:'api/supportrequests/ticketId/:id',component:TrackticketComponent},
  {path:'api/asset/register',component:RegisterassetComponent},
  {path:'api/supportrequests/new',component:CreateticketComponent},
  {path:'**',component:PagenotfoundComponent}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
