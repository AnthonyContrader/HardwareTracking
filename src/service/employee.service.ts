import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { EmployeeDTO } from 'src/dto/employeedto';
import { stringify } from '@angular/core/src/util';
import { ItemDTO } from 'src/dto/itemdto';

/**

 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */

@Injectable({
  providedIn: 'root'
})

export class EmployeeService extends AbstractService<EmployeeDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'employee';
    this.port = '8080';
  }

}

