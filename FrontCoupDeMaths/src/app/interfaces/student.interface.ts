import { Question } from "./question.interface";

export interface Student {
    id: number,
    name: string,
    email: string,
    password: string,
    credits: number,
    questions: Question[]
}
