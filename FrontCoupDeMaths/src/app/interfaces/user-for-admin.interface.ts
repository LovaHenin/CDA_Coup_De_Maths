import { Role } from "./role.interface";

export interface UserForAdmin {
    id:number,
    name: string,
    email: string,
    //password?: string;
    roles: Role[],
    credits: number
}
