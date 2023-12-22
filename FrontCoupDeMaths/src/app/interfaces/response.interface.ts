import { Question } from "./question.interface";
import { User } from "./user.interface";

export interface Response {
    id: number;
    response: string;
    responseDate: string;
    questionId: number | null;
    question: Question | null;
    professorId: number | null;
    professor: User | null;
    docs: Document[];
}
