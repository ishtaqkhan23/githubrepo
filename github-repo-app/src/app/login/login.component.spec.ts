import { LoginComponent } from './login.component';

import { TestBed, getTestBed, ComponentFixture, async } from '@angular/core/testing';
import { Router } from '@angular/router';
import { DebugElement } from '@angular/core';
import { LoginService } from '../login.service';
import { of } from 'rxjs';
import { FormsModule } from '@angular/forms';
describe('LoginComponent', () => {
    let component: LoginComponent;
    let fixture: ComponentFixture<LoginComponent>;
    let de: DebugElement;
    let serviceStub: any;
    let router: Router;

    beforeEach(async () => {
        serviceStub = {
            login: (username: string, password: string) => of('token'),
        };
        const router1 = {
            navigate: jasmine.createSpy('navigate')
        };
        TestBed.configureTestingModule({
            declarations: [LoginComponent],
            imports: [FormsModule],
            providers: [{ provide: LoginService, useValue: serviceStub }, { provide: Router, useValue: router1 }]
        }).compileComponents();
    });

    beforeEach(() => {
        // create component and test fixture
        fixture = TestBed.createComponent(LoginComponent);

        component = fixture.componentInstance;
        de = fixture.debugElement;
        router = TestBed.get(Router);
    });

    it('component should be defined', () => {
        expect(component).toBeDefined();
    });

    it('login() should navigate to repository ', () => {
        component.login();
        expect(router.navigate).toHaveBeenCalledWith(['/repository']);
    });
});
