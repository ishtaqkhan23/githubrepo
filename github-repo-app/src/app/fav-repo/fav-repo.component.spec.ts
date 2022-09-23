import { FavRepoComponent } from './fav-repo.component';

import { TestBed, getTestBed, ComponentFixture, async } from '@angular/core/testing';
import { Router } from '@angular/router';
import { DebugElement } from '@angular/core';
import { RepositoryService } from '../repository.service';
import { of } from 'rxjs';
import { FormsModule } from '@angular/forms';

describe('FavRepoComponent', () => {
    let component: FavRepoComponent;
    let fixture: ComponentFixture<FavRepoComponent>;
    let de: DebugElement;
    let serviceStub: any;
    let router: Router;

    beforeEach(async () => {
        serviceStub = {
            getFavRepos: (username: string) => of([{ id: 1, repoName: '', repoLocation: '' }]),
        };
        const router1 = {
            navigate: jasmine.createSpy('navigate')
        };
        TestBed.configureTestingModule({
            declarations: [FavRepoComponent],
            imports: [FormsModule],
            providers: [{ provide: RepositoryService, useValue: serviceStub }, { provide: Router, useValue: router1 }]
        }).compileComponents();
    });

    beforeEach(() => {
        // create component and test fixture
        fixture = TestBed.createComponent(FavRepoComponent);

        component = fixture.componentInstance;
        de = fixture.debugElement;
        router = TestBed.get(Router);
    });

    it('component should be defined', () => {
        expect(component).toBeDefined();
    });

    it('userrepos should be defined ', () => {
        expect(component.userRepos).toBeDefined();
    });


    it('userrepos should be equal ', () => {
        expect(component.userRepos).toEqual([{ id: 1, repoName: '', repoLocation: '' }]);
    });
});
