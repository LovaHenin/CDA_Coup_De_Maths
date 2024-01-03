import { User } from "./user.interface";

export interface SessionStorage {
    user: User,
    token: string
}
