import { RegitrationServiceService } from './regitration-service.service';

import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { User } from './User';

describe('RegistrationService', () => {
    let injector: TestBed;
    let service: RegitrationServiceService;
    let httpMock: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [RegitrationServiceService],
        });

        injector = getTestBed();
        service = injector.get(RegitrationServiceService);
        httpMock = injector.get(HttpTestingController);
    });

    afterEach(() => {
        httpMock.verify();
    });

    const registrationResponse: User = { username: 'George',
     email: 'https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg', password: 'password' };

    const registrationRequest: User = { username: 'George',
     email: 'https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg', password: 'password' };

    it('createUser() should return data', () => {
        service.registerUser(registrationRequest).subscribe((res) => {
            expect(res).not.toBeNull();
        });

        const req = httpMock.expectOne('http://localhost:8762/register/signup');
        expect(req.request.method).toBe('POST');
        req.flush(registrationRequest);
    });
});
