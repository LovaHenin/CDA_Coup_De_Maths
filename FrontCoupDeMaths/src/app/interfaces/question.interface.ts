import { User } from "./user.interface";
import { Document } from "./document.interface";
import { Response } from "./response.interface";

export interface Question {
    id: number;
    question: string;
    level: string;
    questionType: string;
    questionDate: string;
    studentId: number | null;
    student: User | null;
    docs: Document[];
    responses: Response[];
}
