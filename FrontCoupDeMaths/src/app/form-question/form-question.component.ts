import { Component, OnInit } from '@angular/core';
import { TypeQuestion } from '../enums/type-question';


@Component({
  selector: 'app-form-question',
  templateUrl: './form-question.component.html',
  styleUrls: ['./form-question.component.scss']
})
export class FormQuestionComponent implements OnInit {
ngOnInit(): void {
  
}

handleFileInput(event: any): void {
  const file = event.target.files[0];

  if (file) {
    // Accédez au nom et au chemin du fichier
    const fileName = file.name;
    const filePath = URL.createObjectURL(file);

    // Faites quelque chose avec le nom et le chemin du fichier, par exemple, stockez-les dans votre modèle
    // this.model.docName = fileName;
    // this.model.docPath = filePath;
  }
}
}
