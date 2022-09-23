import { RepositoryService } from './repository.service';
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Observable, observable, of } from 'rxjs';
import { Reposiroty } from './repository.model';
import { RepositoryComponent } from './repository/repository.component';

describe('RepositoryService', () => {
  let injector: TestBed;
  let service: RepositoryService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RepositoryService],
    });

    injector = getTestBed();
    service = injector.get(RepositoryService);
    httpMock = injector.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  const dummyRepoListResponse: Reposiroty[] =
    [
      { id: 1, repoName: 'George', repoLocation: 'https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg' },
      { id: 2, repoName: 'Janet', repoLocation: 'https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg' },
      { id: 3, repoName: 'Emma', repoLocation: 'https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg' }
    ];

  it('getUserList() should return data', () => {
    service.getAllRepos().subscribe((res) => {
      expect(res).toEqual(dummyRepoListResponse);
    });

    const req = httpMock.expectOne('http://localhost:8762/favorite/repository');
    expect(req.request.method).toBe('GET');
    req.flush(dummyRepoListResponse);
  });
});




