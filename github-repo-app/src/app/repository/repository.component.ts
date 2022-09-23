import { Component, OnInit } from '@angular/core';
import { Reposiroty } from '../repository.model';
import { RepositoryService } from '../repository.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-repository',
  templateUrl: './repository.component.html',
  styleUrls: ['./repository.component.css']
})
export class RepositoryComponent implements OnInit {
  repos: Reposiroty[];
  username: string;
  constructor(private repoService: RepositoryService, private router: Router) {
    repoService.getAllRepos().subscribe(repos => this.repos = repos);
    this.username = sessionStorage.getItem('username');
  }

  ngOnInit() {
  }
  addRepoToFav(repoId: number): boolean {
    let repos = false;
    this.repoService.addRepoToFav(sessionStorage.getItem('username'), repoId).subscribe(data => repos = data);
    return repos;
  }

  logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('username');
    this.router.navigate(['/login']);
  }
}
