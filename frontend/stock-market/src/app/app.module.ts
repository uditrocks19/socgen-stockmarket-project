import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { ComparisonChartsComponent } from './components/comparison-charts/comparison-charts.component';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { IposComponent } from './components/ipos/ipos.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SectorsComponent } from './components/sectors/sectors.component';
import { StockExchangesComponent } from './components/stock-exchanges/stock-exchanges.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { CreateCompanyComponent } from './components/companies/create-company/create-company.component';
import { DetailCompanyComponent } from './components/companies/detail-company/detail-company.component';
import { EditCompanyComponent } from './components/companies/edit-company/edit-company.component';
import { CreateStockExchangeComponent } from './components/stock-exchanges/create-stock-exchange/create-stock-exchange.component';
import { DetailStockExchangeComponent } from './components/stock-exchanges/detail-stock-exchange/detail-stock-exchange.component';
import { EditStockExchangeComponent } from './components/stock-exchanges/edit-stock-exchange/edit-stock-exchange.component';
import { CreateSectorComponent } from './components/sectors/create-sector/create-sector.component';
import { DetailSectorComponent } from './components/sectors/detail-sector/detail-sector.component';
import { EditSectorComponent } from './components/sectors/edit-sector/edit-sector.component';
import { CreateIpoComponent } from './components/ipos/create-ipo/create-ipo.component';
import { EditIpoComponent } from './components/ipos/edit-ipo/edit-ipo.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminNavbarComponent,
    CompaniesComponent,
    ComparisonChartsComponent,
    ImportExcelComponent,
    IposComponent,
    NavbarComponent,
    SectorsComponent,
    StockExchangesComponent,
    UserNavbarComponent,
    CreateCompanyComponent,
    DetailCompanyComponent,
    EditCompanyComponent,
    CreateStockExchangeComponent,
    DetailStockExchangeComponent,
    EditStockExchangeComponent,
    CreateSectorComponent,
    DetailSectorComponent,
    EditSectorComponent,
    CreateIpoComponent,
    EditIpoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
