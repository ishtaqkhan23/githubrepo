import { RegisterComponent } from './register.component';
import { TestBed, getTestBed, ComponentFixture, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Router } from '@angular/router';
import { DebugElement } from '@angular/core';
import { RegitrationServiceService } from '../regitration-service.service';
import { of } from 'rxjs';
import { User } from '../User';
import { FormsModule } from '@angular/forms';

describe('RegistrationComponent', () => {
    let component: RegisterComponent;
    let fixture: ComponentFixture<RegisterComponent>;
    let de: DebugElement;
    let serviceStub: any;
    let router: Router;

    beforeEach(async () => {
        serviceStub = {
            registerUser: (user: User) => of(true),
        };
        const router1 = {
            navigate: jasmine.createSpy('navigate')
        };
        TestBed.configureTestingModule({
            declarations: [RegisterComponent],
            imports: [RouterTestingModule, FormsModule],
            providers: [{ provide: RegitrationServiceService, useValue: serviceStub }, { provide: Router, useValue: router1 }]
        }).compileComponents();
    });

    beforeEach(() => {
        // create component and test fixture
        fixture = TestBed.createComponent(RegisterComponent);
        // get test component from the fixture
        component = fixture.componentInstance;
        de = fixture.debugElement;
        router = TestBed.get(Router);

    });
    it('component should be defined', () => {
        expect(component).toBeDefined();
    });

    it('user should be defined', () => {
        expect(component.user).toBeDefined();
    });

    it('router should navigate to /login', () => {
        component.register();
        expect(router.navigate).toHaveBeenCalledWith(['/login']);
    });

});
