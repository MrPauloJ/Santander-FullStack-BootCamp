import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  logoUrl:string ="https://www.seekpng.com/png/detail/428-4289671_logo-e-commerce-good-e-commerce-logo.png";
  constructor() {}

  ngOnInit(): void {
  }

}
