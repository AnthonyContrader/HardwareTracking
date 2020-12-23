import { EmployeeDTO } from "./employeedto";


export class ItemDTO{

    id: number;

    name: string;

    price: number;

    owners: EmployeeDTO[];

}