import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { parseTemplate } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class ApiResponseService {
  private url:string = "";
  constructor() { }

  private itemsList:Object[]=[
    {
      "Technology":
      [
        {"img":"https://source.unsplash.com/800x600/?technology","title":"Titulo1","price":100,"description":"computer"},
        {"img":"https://source.unsplash.com/800x600/?technology","title":"Titulo2","price":200,"description":"pc"},
        {"img":"https://source.unsplash.com/800x600/?technology","title":"Titulo3","price":300,"description":"iphone"},
        {"img":"https://source.unsplash.com/800x600/?technology","title":"Titulo4","price":400,"description":"fullstack"}
      ]
    },
    {
      "Books":
      [
        {"img":"https://source.unsplash.com/800x600/?Books","title":"Titulo1","price":10,"description":"Karienina"},
        {"img":"https://source.unsplash.com/800x600/?Books","title":"Titulo2","price":20,"description":"Potter"},
        {"img":"https://source.unsplash.com/800x600/?Books","title":"Titulo3","price":30,"description":"JSON"},
        {"img":"https://source.unsplash.com/800x600/?Books","title":"Titulo4","price":40,"description":"Python"}
      ]
    },
    {
      "Art":
      [
        {"img":"https://source.unsplash.com/800x600/?Art","title":"Titulo1","price":10,"description":"Lodon"},
        {"img":"https://source.unsplash.com/800x600/?Art","title":"Titulo2","price":20,"description":"Italy"},
        {"img":"https://source.unsplash.com/800x600/?Art","title":"Titulo3","price":30,"description":"Span"},
        {"img":"https://source.unsplash.com/800x600/?Art","title":"Titulo4","price":40,"description":"You"}
      ]
    },
    {
      "Business":
      [
        {"img":"https://source.unsplash.com/800x600/?Business","title":"Titulo1","price":10,"description":"Ecommerce"},
        {"img":"https://source.unsplash.com/800x600/?Business","title":"Titulo2","price":20,"description":"Bitcoin"},
        {"img":"https://source.unsplash.com/800x600/?Business","title":"Titulo3","price":30,"description":"LittleCoin"},
        {"img":"https://source.unsplash.com/800x600/?Business","title":"Titulo4","price":40,"description":"Dodge"}
      ]
    },
    {
      "Science":
      [
        {"img":"https://source.unsplash.com/800x600/?Science","title":"Titulo1","price":10,"description":"boom"},
        {"img":"https://source.unsplash.com/800x600/?Science","title":"Titulo2","price":20,"description":"physics"},
        {"img":"https://source.unsplash.com/800x600/?Science","title":"Titulo3","price":30,"description":"science"},
        {"img":"https://source.unsplash.com/800x600/?Science","title":"Titulo4","price":40,"description":"love"}
      ]
    },
    {
      "Healthy":
      [
        {"img":"https://source.unsplash.com/800x600/?Healthy","title":"Titulo1","price":10,"description":"apple"},
        {"img":"https://source.unsplash.com/800x600/?Healthy","title":"Titulo2","price":20,"description":"not apple"},
        {"img":"https://source.unsplash.com/800x600/?Healthy","title":"Titulo3","price":30,"description":"burguer"},
        {"img":"https://source.unsplash.com/800x600/?Healthy","title":"Titulo4","price":40,"description":"idk"}
      ]
    },
    {
      "Style":
      [
        {"img":"https://source.unsplash.com/800x600/?Style","title":"Titulo1","price":10,"description":"sun glass"},
        {"img":"https://source.unsplash.com/800x600/?Style","title":"Titulo2","price":20,"description":"shirt"},
        {"img":"https://source.unsplash.com/800x600/?Style","title":"Titulo3","price":30,"description":"leather"},
        {"img":"https://source.unsplash.com/800x600/?Style","title":"Titulo4","price":40,"description":"pants"}
      ]
    },
    {
      "Travel":
      [
        {"img":"https://source.unsplash.com/800x600/?Travel","title":"Titulo1","price":10,"description":"US"},
        {"img":"https://source.unsplash.com/800x600/?Travel","title":"Titulo2","price":20,"description":"Italy"},
        {"img":"https://source.unsplash.com/800x600/?Travel","title":"Titulo3","price":30,"description":"China"},
        {"img":"https://source.unsplash.com/800x600/?Travel","title":"Titulo4","price":40,"description":"Japan"}
      ]
    },
    {
      "Top10":
      [
        {"img":"https://source.unsplash.com/800x600/?Top","title":"Titulo1","price":10,"description":"fuck"},
        {"img":"https://source.unsplash.com/800x600/?Top","title":"Titulo2","price":20,"description":"the"},
        {"img":"https://source.unsplash.com/800x600/?Top","title":"Titulo3","price":30,"description":"system"},
        {"img":"https://source.unsplash.com/800x600/?Top","title":"Titulo4","price":40,"description":"!!!"}
      ]
    }
  ]

  getData(parametro:string):any{
    for (let item of this.itemsList){
      if(item.hasOwnProperty(parametro))
      return item
    }
  }

  setData():void{
    
  }

}
