import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiResponseService } from 'src/app/services/api-response.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  private parametro: string = "";
  itemList:any[]=[{"img":"","title":"title","price":0,"description":"none"}];
  
  constructor(private currentRoute:ActivatedRoute, private dataGetter:ApiResponseService) { }

  ngOnInit(): void {
    this.currentRoute.params.subscribe((parametros:any)=>{
      this.parametro=parametros.nome;
      console.log(this.parametro)
      this.itemList = this.dataGetter.getData(this.parametro)[this.parametro];
      console.log(this.itemList)
    });
  }

}
