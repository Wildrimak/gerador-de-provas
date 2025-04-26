import { Injectable } from '@angular/core';
import { of, throwError } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProcessaQuestoesService {
  
    processarQuestoes(questoes: string, gabarito: string) {

        if (!questoes.trim() || !gabarito.trim()) {
          return throwError(() => new Error('Questões ou Gabarito vazios')).pipe(delay(1000));
        }
        
        return of({ message: 'Processado com sucesso!' }).pipe(delay(1000));

    }

}
