import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reposiroty } from './repository.model';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {
  addRepoToFav(username: string, repoId: number): Observable<boolean> {
    const userReposURL = `http://localhost:8762/favorite/user/${username}/${repoId}`;
    // const userReposURL = `http://localhost:8081/favorite/user/${username}/${repoId}`;
    return this.http.get<boolean>(userReposURL);
  }


  constructor(private http: HttpClient) { }

  getFavRepos(username: string): Observable<Reposiroty[]> {
    const userReposURL = `http://localhost:8762/favorite/user/${username}`;
    // const userReposURL = `http://localhost:8081/favorite/user/${username}`;
    return this.http.get<Reposiroty[]>(userReposURL);
  }
  getAllRepos(): Observable<Reposiroty[]> {
    const userReposURL = `http://localhost:8762/favorite/repository`;
    // const userReposURL = `http://localhost:8081/favorite/repository`;
    return this.http.get<Reposiroty[]>(userReposURL);
  }
  removeRepoFromFav(username: string, repoId: number): Observable<boolean> {
    const userReposURL = `http://localhost:8762/favorite/user/${username}/${repoId}`;
    // const userReposURL = `http://localhost:8081/favorite/user/${username}/${repoId}`;
    return this.http.delete<boolean>(userReposURL);
  }
}
