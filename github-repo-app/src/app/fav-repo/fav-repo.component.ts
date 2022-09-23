import { Component, OnInit } from '@angular/core';
import { Reposiroty } from '../repository.model';
import { RepositoryService } from '../repository.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fav-repo',
  templateUrl: './fav-repo.component.html',
  styleUrls: ['./fav-repo.component.css']
})
export class FavRepoComponent implements OnInit {

  public userRepos: Reposiroty[];
  username: string;
  constructor(private repoService: RepositoryService, private router: Router) {
    this.username = sessionStorage.getItem('username');
    repoService.getFavRepos(sessionStorage.getItem('username')).subscribe(userRepos => this.userRepos = userRepos);
  }

  removeRepoFromFav(repoId: number) {
    this.repoService.removeRepoFromFav(sessionStorage.getItem('username'), repoId)
      .subscribe(data => this.repoService.getFavRepos(sessionStorage.getItem('username'))
        .subscribe(userRepos => this.userRepos = userRepos));

  }

  ngOnInit() {
  }

  logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('username');
    this.router.navigate(['/login']);
  }
}
