import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FavRepoComponent } from './fav-repo/fav-repo.component';
import { RepositoryComponent } from './repository/repository.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';


export const routes: Routes = [
  { path: 'favorites', component: FavRepoComponent, canActivate: [AuthGuard] },
  { path: 'repository', component: RepositoryComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/repository', pathMatch: 'full', canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash : true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
