package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileFiller {
    private File file;
    private FileWriter fileWriter;

    /**
     * @param file file, which should be filled with some content
     * @throws IOException
     */
    public FileFiller(File file) throws IOException {
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        if (file.canWrite()) {
            this.file = file;
        } else {
            throw new IOException("Can not write to file or file not exists");
        }
    }

    /**
     * Clears all content from file
     */
    public void clearFile() {
        try {
            fileWriter = new FileWriter(file, false);
            //fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Refills file with "lorem ipsum"
     */
    public void fillLorem() {
        try {
            final String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
            fileWriter = new FileWriter(file, false);
            fileWriter.write(lorem);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Refills file with poem "Knows how to forget!" by Emily Dickinson, 1830 - 1886
     */
    public void fillPoem() {
        try {
            String poem = "Knows how to forget!\n" +
                    "Emily Dickinson, 1830 - 1886\n" +
                    "\n" +
                    "Knows how to forget!\n" +
                    "But could It teach it?\n" +
                    "Easiest of Arts, they say\n" +
                    "When one learn how\n" +
                    "\n" +
                    "Dull Hearts have died\n" +
                    "In the Acquisition\n" +
                    "Sacrificed for Science\n" +
                    "Is common, though, now —\n" +
                    "\n" +
                    "I went to School\n" +
                    "But was not wiser\n" +
                    "Globe did not teach it\n" +
                    "Nor Logarithm Show\n" +
                    "\n" +
                    "“How to forget”!\n" +
                    "Say — some — Philosopher!\n" +
                    "Ah, to be erudite\n" +
                    "Enough to know!\n" +
                    "\n" +
                    "Is it in a Book?\n" +
                    "So, I could buy it —\n" +
                    "Is it like a Planet?\n" +
                    "Telescopes would know —\n" +
                    "\n" +
                    "If it be invention\n" +
                    "It must have a Patent.\n" +
                    "Rabbi of the Wise Book\n" +
                    "Don’t you know?";

            fileWriter = new FileWriter(file, false);
            fileWriter.write(poem);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillWordsWithSameEndStart() {
        try {
            String content = "word dorn removed some eon need removed owkland dorn\n" +
                    "palindromes: nixin nixin nixin nixin nixin";
            fileWriter = new FileWriter(file, false);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillWordsWithNumbers() {
        try {
            String content = "lorem ipsum 026 dolor 003125476 sit amet 645234\n" +
                    "consectetur 21 311 64 adipisicing elit 0.1567\n" +
                    "sed 0123 do 4563 eiusmod";
            fileWriter = new FileWriter(file, false);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillNabokov() {
        try {
            String content = "На  углу,  под  шатром  цветущей  липы, обдало меня буйным\n" +
                    "благоуханием. Туманные громады поднимались по ночному  небу,  и\n" +
                    "когда  поглощен  был  последний звездный просвет, слепой ветер,\n" +
                    "закрыв лицо рукавами, низко пронесся вдоль опустевшей улицы.  В\n" +
                    "тусклой темноте, над железным ставнем парикмахерской, маятником\n" +
                    "заходил висячий щит, золотое блюдо.\n" +
                    "     Вернувшись  домой,  я  застал  ветер  уже в комнате: -- он\n" +
                    "хлопнул оконной рамой и поспешно отхлынул, когда я  прикрыл  за\n" +
                    "собою  дверь.  Внизу,  под  окном,  был глубокий двор, где днем\n" +
                    "сияли,  сквозь  кусты  сирени,  рубашки,  распятые  на  светлых\n" +
                    "веревках,  и  откуда  взлетали порой, печальным лаем, голоса,--\n" +
                    "старьевщиков,   закупателей   пустых   бутылок,--    нет-нет,--\n" +
                    "разрыдается  искалеченная  скрипка;  и  однажды  пришла  тучная\n" +
                    "белокурая женщина, стала посреди двора, да так  хорошо  запела,\n" +
                    "что  из всех окон свесились горничные, нагнулись голые шеи,-- и\n" +
                    "потом, когда женщина кончила петь, стало необыкновенно  тихо,--\n" +
                    "только  в коридоре всхлипывала и сморкалась неопрятная вдова, у\n" +
                    "которой я снимал комнату.\n" +
                    "     А теперь там внизу набухала душная мгла,-- но  вот  слепой\n" +
                    "ветер, что беспомощно сполз в глубину, снова потянулся вверх,--\n" +
                    "и вдруг -- прозрел, взмыл, и в янтарных провалах в черной стене\n" +
                    "напротив  заметались  тени  'рук, волос, ловили улетающие рамы,\n" +
                    "звонко и крепко запирали окна. Окна  погасли.  И  тотчас  же  в\n" +
                    "темно-лиловом   небе   тронулась,   покатилась   глухая  груда,\n" +
                    "отдаленный гром. И стало тихо, как тогда, когда замолкла нищая,\n" +
                    "прижав руки к полной груди.\n" +
                    "     В этой тишине я заснул,  ослабев  от  счастия,  о  котором\n" +
                    "писать не умею,-- и сон мой был полон тобой.\n" +
                    "     Проснулся  я  оттого,  что  ночь  рушилась. Дикое, бледное\n" +
                    "блистание летало по небу, как быстрый отсвет исполинских  спиц.\n" +
                    "Грохот за грохотом ломал небо. Широко и шумно шел дождь.\n" +
                    "     Меня  опьянили  эти  синеватые содрогания, легкий и острый\n" +
                    "холод. Я стал у мокрого подоконника, вдыхая неземной воздух, от\n" +
                    "которого сердце звенело, как стекло.\n" +
                    "     Все ближе, все великолепнее гремела по  облакам  колесница\n" +
                    "пророка. Светом сумасшествия, пронзительных видений, озарен был\n" +
                    "ночной   мир,  железные  склоны  крыш.  бегущие  кусты  спреин.\n" +
                    "Громовержец, седой исполин, с бурной бородою, закинутой  ветром\n" +
                    "за  плечо, в ослепительном, летучем облачении, стоял, подавшись\n" +
                    "назад, на огненной колеснице и  напряженными  руками  сдерживал\n" +
                    "гигантских  коней  своих: -- вороная масть, гривы -- фиолетовый\n" +
                    "пожар. Они понесли, они  брызгали  трескучей  искристой  пеной,\n" +
                    "колесница кренилась, тщетно рвал вожжи растерянный пророк. Лицо\n" +
                    "его было искажено ветром и напряжением, вихрь, откинув складки,\n" +
                    "обнажил  могучее колено,-- а кони, взмахивая пылающими гривами,\n" +
                    "летели -- все буйственнее -- вниз по тучам, вниз. Вот  громовым\n" +
                    "шепотом промчались они по блестящей крыше, колесницу шарахнуло,\n" +
                    "зашатался  Илья,--  и  кони,  обезумев от прикосновения земного\n" +
                    "металла, снова  вспрянули.  Пророк  был  сброшен.  Одно  колесо\n" +
                    "отшибло.  Я  видел  из своего окна, как покатился вниз по крыше\n" +
                    "громадный огненный обод и, покачнувшись  на  краю,  .прыгнул  в\n" +
                    "сумрак.   А   кони,   влача  за  собою  опрокинутую,  прыгающую\n" +
                    "колесницу, уже летели по вышним тучам, гул умолкал,  и  вот  --\n" +
                    "грозовой огонь исчез в лиловых безднах.\n" +
                    "     Громовержец,  павший  на крышу, грузно встал, плесницы его\n" +
                    "заскользили,-- он ногой пробил слуховое окошко, охнул,  широким\n" +
                    "движением   руки   удержался  за  трубу.  Медленно  поворачивая\n" +
                    "потемневшее лицо. он  что-то  искал  глазами,--  верно  колесо,\n" +
                    "соскочившее  с  золотой  оси.  Потом  глянул  вверх, вцепившись\n" +
                    "пальцами в растрепанную бороду, сердито покачал головой,--  это\n" +
                    "случалось вероятно не впервые,-- и, прихрамывая, стал осторожно\n" +
                    "спускаться.\n" +
                    "     Оторвавшись  от  окна, спеша и волнуясь, я накинул халат и\n" +
                    "сбежал по крутой лестнице прямо во двор. Гроза отлетела, но еще\n" +
                    "веял дождь. Восток дивно бледнел.\n" +
                    "     Двор, что сверху казался налитым густым сумраком,  был  на\n" +
                    "самом  деле полон тонким тающим туманом. Посередине, на тусклом\n" +
                    "от сырости газоне, стоял сутулый, тощий старик в промокшей рясе\n" +
                    "и бормотал что-то, посматривая по сторонам.  Заметив  меня,  он\n" +
                    "сердито моргнул:\n" +
                    "     -- Ты, Елисей?\n" +
                    "     Я   поклонился.  Пророк  цокнул  языком,  потирая  ладонью\n" +
                    "смуглую лысину: -- Колесо потерял. Отыщи-ка.\n" +
                    "     Дождь  перестал.  Над  крышами  пылали  громадные  облака.\n" +
                    "Кругом,  в  синеватом,  сонном  воздухе,  плавали кусты, забор,\n" +
                    "блестящая собачья конура. Долго шарили мы  по  углам,--  старик\n" +
                    "кряхтел, подхватывал тяжелый подол, шлепал тупыми сандалиями по\n" +
                    "лужам,  и  с  кончика  крупного костистого носа свисала светлая\n" +
                    "капля. Отодвинув низкую ветку сирени, я заметил на  куче  сору,\n" +
                    "среди  битого  стекла,  тонкое  железное  колесо,--  видимо  от\n" +
                    "детской коляски, Старик жарко дохнул  над  самым  моим  ухом  и\n" +
                    "поспешно,  даже  грубовато  отстранив  меня,  схватил  и поднял\n" +
                    "ржавый круг. Радостно подмигнул мне:\n" +
                    "     -- Вот куда закатилось...\n" +
                    "     Потом на меня уставился, сдвинув седые брови,-- и,  словно\n" +
                    "что-то вспомнив, внушительно сказал:\n" +
                    "     -- Отвернись, Елисей.\n" +
                    "     Я  послушался.  Даже зажмурился. Постоял так с минуту,-- и\n" +
                    "дольше не выдержал...\n" +
                    "     Пустой двор. Только старая  лохматая  собака  с  поседелой\n" +
                    "мордой  вытянулась  из  конуры  и,  как  человек, глядела вверх\n" +
                    "испуганными карими глазами. Я поднял  голову.  Илья  карабкался\n" +
                    "вверх  по  крыше, и железный обод поблескивал у него за спиной.\n" +
                    "Над черными трубами оранжевой  кудрявой  горой  стояло  заревое\n" +
                    "облако,  за  ним  второе, третье. Мы глядели вместе с притихшей\n" +
                    "собакой, как пророк, поднявшись до  гребня  крыши,  спокойно  и\n" +
                    "неторопливо  перебрался  на  облако  и стал лезть вверх, тяжело\n" +
                    "ступая по рыхлому огню.\n" +
                    "     Солнце стрельнуло в его колесо, и оно сразу стало золотым,\n" +
                    "громадным,-- да и сам Илья казался теперь облаченным  в  пламя,\n" +
                    "сливаясь  с  той райской тучей, по которой он шел все выше, все\n" +
                    "выше, пока не исчез в пылающем воздушном ущелье.\n" +
                    "     Только тогда хриплым утренним лаем залился дряхлый  пес,--\n" +
                    "и  хлынула  рябь по яркой глади дождевой лужи; от легкого ветра\n" +
                    "колыхнулась пунцовая герань  на  балконах,  проснулись  два-три\n" +
                    "окна,--  и  в  промокших  клетчатых  туфлях, в блеклом халате я\n" +
                    "выбежал на улицу и, догоняя первый, сонный  трамвай,  запахивая\n" +
                    "полы  на  бегу,  все посмеивался, воображая, как сейчас приду к\n" +
                    "тебе и  буду  рассказывать  о  ночном,  воздушном  крушении,  о\n" +
                    "старом, сердитом пророке, упавшем ко мне во двор.";
            fileWriter = new FileWriter(file, false);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
