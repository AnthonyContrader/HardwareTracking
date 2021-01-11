import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { ItemLentDTO } from 'src/dto/itemlentdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */

@Injectable({
  providedIn: 'root'
})

export class ItemLentService{
  

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<ItemLentDTO[]> {
    return this.http.get<ItemLentDTO[]>('http://localhost:8080/track/getall');
}


  request(dto: ItemLentDTO): Observable<any> {
    return this.http.post('http://localhost:8080/track/request', dto);
  }

  getMyRequests(fiscalCode: string): Observable<ItemLentDTO[]>{
      return this.http.get<ItemLentDTO[]>('http://localhost:8080/track/getmyrequests/' + fiscalCode);
  }

  return(info: string): Observable<any>{
    return this.http.delete('http://localhost:8080/track/return/' + info);
  }

  downloadStandard(): Observable<any>{
    return this.http.get('http://localhost:8080/track/downloadstandard');
  }

  downloadTable(): Observable<any>{
    return this.http.get('http://localhost:8080/track/downloadtable');
  }


}