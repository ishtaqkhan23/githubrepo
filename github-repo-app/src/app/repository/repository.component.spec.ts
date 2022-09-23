import { RepositoryComponent } from './repository.component';
import { TestBed, getTestBed, ComponentFixture, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Router } from '@angular/router';
import { DebugElement } from '@angular/core';
import { RepositoryService } from '../repository.service';
import { of } from 'rxjs';
import { Reposiroty } from '../repository.model';

describe('RepositoryComponent', () => {
    let component: RepositoryComponent;
    let fixture: ComponentFixture<RepositoryComponent>;
    let de: DebugElement;
    let serviceStub: any;
    let router: Router;

    beforeEach(async () => {
        serviceStub = {
            addRepoToFav: (username: string, repoId: number) => true,
            getAllRepos: () => of([{ id: 1, repoName: '', repoLocation: '' }])
        };
        TestBed.configureTestingModule({
            declarations: [RepositoryComponent],
            imports: [RouterTestingModule],
            providers: [{ provide: RepositoryService, useValue: serviceStub }]
        }).compileComponents();


    });

    beforeEach(() => {
        fixture = TestBed.createComponent(RepositoryComponent);
        component = fixture.componentInstance;
        de = fixture.debugElement;
        router = TestBed.get(Router);
    });
    it('shold be defined', () => {
        expect(component).toBeDefined();
    });

    it('repos shold be defined', () => {
        expect(component.repos).toBeDefined();
    });

    it('repositories shold be equal', () => {
        const repos: Reposiroty[] = [{ id: 1, repoName: '', repoLocation: '' }];
        expect(component.repos).toEqual(repos);
    });

});
