import org.threeten.extra.Temporals;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) throws IOException {

        //LocalDate date = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        LocalDate data = LocalDate.of(2023, 3, 27);

        System.out.println("DiaUtilAnterior: "+ getDiaUtilAnterior(data));

        //LocalDate diaSemana = LocalDate.now(ZoneId.of("America/Sao_Paulo")).with(Temporals.previousWorkingDay());

        ArrayList<LocalDate> datas = new ArrayList<>();


                for(int j=1;j<13;j++){
                    for(int i=1;i<32;i++){
                        if(j ==2 &&i== 29) continue;
                        if(j ==2 &&i== 30) continue;
                        if(j ==2 &&i== 31) continue;
                        if(j ==4 &&i== 31) continue;
                        if(j ==6 &&i== 31) continue;
                        if(j ==9 &&i== 31) continue;
                        if(j ==11 &&i== 31) continue;
                        LocalDate date = LocalDate.of(2023, j, i);
                        datas.add(date);
                    }

                }
/**
        for(LocalDate data: datas){
            LocalDate previousWorkingDay =  data.with(Temporals.previousWorkingDay());

            if(isHoliday(previousWorkingDay)){

                while(isHoliday(previousWorkingDay) || isWeekend(previousWorkingDay)){
                    previousWorkingDay = previousWorkingDay.minusDays(1);
                }

                System.out.println("data: "+data+" ---  diaUtilAnterior: "+ previousWorkingDay);
            } else{
                System.out.println("data: "+data+" ---  diaUtilAnterior: "+ previousWorkingDay);
            }

        }

        System.out.println("fim");
**/

    }

    public static LocalDate getDiaUtilAnterior(LocalDate data){

            LocalDate previousWorkingDay =  data.with(Temporals.previousWorkingDay());

            if(isHoliday(previousWorkingDay)){

                while(isHoliday(previousWorkingDay) || isWeekend(previousWorkingDay)){
                    previousWorkingDay = previousWorkingDay.minusDays(1);
                }
                return previousWorkingDay;
            } else{
                return previousWorkingDay;
            }

    }

    public static boolean isHoliday(LocalDate date){

        ArrayList<LocalDate> feriados = new ArrayList<>();
        feriados.add(LocalDate.of(2023, 3, 29));
        feriados.add(LocalDate.of(2023, 3, 28));
        feriados.add(LocalDate.of(2023, 3, 24));

        return feriados.contains(date);

    }

    public static boolean isWeekend(LocalDate date) {
        if (isSaturday(date) || isSunday(date))
            return true;
        else
            return false;
    }

    private static boolean isSunday(LocalDate date) {
        return DayOfWeek.SUNDAY.equals(date.getDayOfWeek());
    }

    private static boolean isSaturday(LocalDate date){
        return DayOfWeek.SATURDAY.equals(date.getDayOfWeek());
    }






}
