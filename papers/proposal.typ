#set page(paper: "us-letter")

#let author = "Алекса Ћетковић <cetkovic.sv77.2022@uns.ac.rs>"

#set document(
  title: "DroolMate: Експертски систем за повезивање власника и паса",
  description: "Приједлог пројекта: DroolMate - Експертски систем за повезивање власника и паса",
  author: author,
  keywords: ("breed recommendation", "knowledge-based systems", "dog selection", "assistance dogs", "expert systems"),
)

#let fonts = (
  body: "Times New Roman",
  sans: "...",
  math: "STIX Two Math",
  mono: "JetBrains Mono",
)

#set text(
  lang: "sr",
  script: "Cyrl",
  size: 11pt,

  font: fonts.body,
)
#show math.equation: set text(font: fonts.math)
#show raw: set text(font: fonts.mono)
#show heading: it => {
  set text(
    hyphenate: false,
    font: fonts.body,
  )
  block(
    above: 1.5em,
    below: 0.84em,
    it,
  )
} // maybe use sans for headings
#set par(justify: true)

#title()
#strong(author)

#v(7.7em)

Пси се већ вјековима користе у специјализованим улогама које захтјевају пажљиву селекцију како би њихове особине биле усклађивање са захтјевима задатка и корисника. Области као што су терапија уз помоћ животиња (_Animal-Assisted Therapy_ -- _ААТ_), водичке и асистентске улоге за особе са инвалидитетом, спасилачке службе, као и полицијски и гранични надзор, подразумјевају високо стручне процјене при одабиру расе и јединке. Погрешан одабир може довести до неефикасног тренинга, финансијских губитака и, у случају терапијског или асистентског пса, до нарушавања добробити корисника који од њега зависи.

Стручњаци у овим областима, ветеринари, тренери и лиценцирани специјалисти, ослањају се на дубоко доменско знање које је тешко прењети, стандардизовати и скалирати. Овај пројекат има за циљ формализацију тог знања у облику експертског система који може подржати и олакшати професионалне процјене.

= Преглед Проблема

Одабир одговарајуће расе пса за специфичну радну или терапијску улогу није једноставан задатак. Свака улога носи јасне функционалне захтјеве који морају бити усклађени са генетски и биолошки утврђеним карактеристикама расе. На примјер:

- *Пас за разоноду* мора бити смирен, имати високу толеранцију на буку и стрес, природну привлачност према људима и предвидиво понашање у несигурним срединама (болнице, школе, домови за старе)

- *Пас водич за слијепе* мора бити изузетно паметан, мотивисан за задатке, обазрив али не плашљив

- *Радни пас* (који се користи за детекцију дроге и експлозива) мора да има изузетно развијено чуло мириса, јаку мотивацију за рад (кроз игру или храну), високу енергију и отпорност на монотонију тренинга

- *Пас за емоционалну подршку* мора бити психички стабилан, не-агресиван, прилагодљив и способан за формирање јаких емоционалних веза

Овај проблем захтјева експертско знање јер процјена мора да узме у обзир вишеструке, међусобно зависне факторе -- биолошке, бихевиоралне, физичке и контекстуалне -- и да их усклади са захтјевима улоге и профила корисника/организације.

== Преглед Литературе

Доменско знање за систем базирано је на следећим изворима:

- *_The Domestic Dog: Its Evolution, Behavior and Interactions with People_* @serpell2016domestic -- пружа емпиријску основу за разумјевање генетских и бихевиоралних карактеристика раса, као и фактора који утичу на подобност паса за различите радне улоге

- *_Fédération Cynologique Internationale (FCI) Breed Standards_* @fci_breeds -- званични описи раса који дефинишу физичке и бихевиоралне карактеристике, укључујући изглед, пропорције, кретање и темперамент, у складу са међународно признатим стандардима

- *_Assistance Dogs International (ADI) Standards and Ethics_* @adi_standards -- дефинишу минималне захтеве које пас мора испунити за терапијску или асистентску улогу. Ови стандарди се користе као референтни праг у правилима система

- *_Handbook on Animal-Assisted Therapy_* @fine2019handbook -- детаљно описује критеријуме селекције, процјене и обуке терапијских паса, обраћајући посебну пажњу на бихевиоралне тестове (нпр. _Canine Good Citizen_ тест)

- *_Canine Ergonimics: The Science of Working Dogs_* @helton2009canine -- даје научну основу за процјену перформанси радних паса у специфичним улогама

- *_Behavioral profiles of dog breeds_* @hart1985behavioral и *_Selecting pet dogs on the basis of cluster analysis of breed behavior profiles and gender_* @hart1985selecting -- студије Hart, ет. ал у којима је развијена квантитативна метода за описивање понашања раса на основу процјена 96 ветеринара и судија послушности. Факторском анализом 13 особина понашања идентификована су три кључна фактора: *реактивност*, *агресивност* и *подложност обуци*, која заједно објашњавају 81% варијансе.

- Стандардизовани упитници и протоколи за процјену понашања паса (_C-BARQ_, _WDC-BARQ_, _GDBART_, _BCL_ и други) @iwda_wtd

Набројана литература је подложна проширивању током процеса прикупљања знања.

== Постојећa Рјешења

У наставку су наведена постојећа рјешења која адресирају сличан проблем као и њихове кључне слабости:

- *Упитници за општу препоруку раса* (нпр. _"Find the Best Dog Breed for You!"_ @akc_breed_selector) -- не разликују улоге паса и не узимају у обзир стручне критеријуме

- *_Dog Breed Ontology_* @dbo — постоје формалне репрезентације раса и њихових особина у виду онтологија, али су углавном фокусиране на таксономију и биолошке/морфолошке карактеристике, без директног повезивања са конкретним радним улогама за које се пас користи

- *_Vertebrate Breed Ontology (VBO)_* @vbo — широко коришћена биомедицинска онтологија за класификацију раса кичмењака, укључујући псе, али је примарно дизајнирана за интероперабилност у биолошким и генетским базама података, а не за препоруку раса у контексту задатака или улога

- *Ручне процјене стручњака* -- скалабилност је ограничена, резултати субјективни и нема системског биљежења знања

Упркос наведеним приступима, ниједан од њих не омогућава системску и скалабилну препоруку раса паса засновану на конкретним радним улогама и формализованим стручним критеријумима, што представља основну мотивацију за предложено рјешење.

= Методологија

== Очекивани Улази у Систем

Систем очекује следеће улазе:

+ *Упит за улогу* (`RoleQuery`): Једини улаз корисника — идентификатор жељене радне улоге.
  ```
  insert(new RoleQuery("guide_dog"));
  ```
  Подржане улоге, дефинисане у бази знања (`roles.csv`):
  - `therapy_dog` — Пас за терапију
  - `guide_dog` — Пас водич за слијепе
  - `detection_dog` — Пас за детекцију (дрога/експлозиви)
  - `emotional_support_dog` — Пас за емоционалну подршку
  - `mobility_assistance_dog` — Пас за помоћ при кретању
  - `search_rescue_dog` — Пас за претрагу и спасавање

  Сви физички и бихевиорални захтјеви улоге (висина, тежина, Hart-ови прагови) унапред су дефинисани у `roles.csv` и учитавају се у базу знања при покретању — корисник их не наводи.

+ *Профили раса* (интерни улаз): Табела раса паса са карактеристикама, извучена из `breeds.csv` при покретању система. Корисник ову датотеку не прослеђује; одржава је тим експерата:
  - Назив расе и FCI класификација
  - Физичке карактеристике (висина, тежина)
  - Hart-ови бихевиорални фактори (реактивност, агресивност, обучљивост), на скали 0–10

+ *Опциона индивидуална процјена* (Individual Assessment): За конкретну јединку паса, биолошки подаци и резултати стандардизованих тестова понашања (нпр. C-BARQ тест, Canine Good Citizen тест).

== Очекивани Излази из Система

+ *Листа препоручених раса*, рангирана по скору компатибилности, са:
  - Назив расе
  - Укупан скор компатибилности (0-100%)
  - Ниво препоруке: "Excellent" (≥85%), "Good" (≥75%), "Fair" (60-75%), "Not Recommended" (\<60%)
  - Детаљна разбитост: физички скор (30% утицаја) и бихевиорални скор (70% утицаја)

+ *Трага разумевања* (Reasoning Trace): За сваку препоруку, детаљно образложење подељено по слојевима:
  - Слој 1: Физичка евалуација (висина, тежина)
  - Слој 2: Бихевиорална евалуација (Hart-ови фактори и њихово усклађивање са захтјевима)
  - Слој 3: Комбинована процјена и рангирање

+ *Алтернативне опције* за случај да нема раса које у потпуности задовољавају захтјеве, система могу бити приказане раса са нижим скоровима и препоруке за додатну обуку или селекцију.

== Структура Базе Знања

База знања је организована у три слоја forward-chaining реазумевања, сваки са припадајућим agenda групама и правилима:

=== Слој 1: Физичка Евалуација
- *Улаз*: Breed и RoleRequirement чињенице
- *Правила*: Три правила унутар agenda-групе `"physical"`, активираних у низу по salience:
  - (salience 10) *"Evaluate breed height for role"* — упоређује просјечну висину расе са прозором улоге; емитује `PhysicalDimensionFit(dimension="height")`
  - (salience 10) *"Evaluate breed weight for role"* — упоређује просјечну тежину расе са прозором улоге; емитује `PhysicalDimensionFit(dimension="weight")`
  - (salience 5) *"Emit physical score for breed-role pair"* — комбинује обје `PhysicalDimensionFit` чињенице у јединствени скор (100/50/0)
- *Међучињенице*: `PhysicalDimensionFit(breedName, roleId, dimension, value, suitable, reasoning)`
- *Излаз*: `PhysicalScore` чињенице
- *Редослед извршавања*: agenda-групa `"initialization"` → `"physical"` (управља se преко `setFocus()`)

=== Слој 2: Бихевиорална Евалуација
- *Улаз*: Breed, RoleRequirement и PhysicalScore чињенице
- *Правила*: Четири правила унутар agenda-групе `"behavioral"`, активираних у низу по salience:
  - (salience 10) *"Evaluate reactivity fitness for role"* — прорачунава усклађеност реактивности са дозвољеним опсегом улоге; емитује `BehavioralFactorFit(factor="reactivity")`
  - (salience 10) *"Evaluate aggression fitness for role"* — примјењује строги пенал за агресивност изнад прага улоге; емитује `BehavioralFactorFit(factor="aggression")`
  - (salience 10) *"Evaluate trainability fitness for role"* — процјењује да ли обучљивост прелази минимум захтеван за улогу; емитује `BehavioralFactorFit(factor="trainability")`
  - (salience 5) *"Emit behavioral score for breed-role pair"* — комбинује три `BehavioralFactorFit` чињенице пондерисаним просјеком (обучљивост 50%, агресивност 30%, реактивност 20%)
- *Међучињенице*: `BehavioralFactorFit(breedName, roleId, factor, rawScore, fitScore, reasoning)`
- *Излаз*: `BehavioralScore` чињенице са детаљном разбитошћу по фактору
- *Редослед извршавања*: agenda-група `"physical"` → `"behavioral"` (управља се преко `setFocus()`)

=== Слој 3: Компатибилност и Рангирање
- *Улаз*: PhysicalScore и BehavioralScore чињенице
- *Правила*: Четири правила унутар agenda-групе `"compatibility"`, активираних у низу по salience:
  - (salience 15) *"Compute combined compatibility score"* — израчунава пондерисани скор (30% физичко + 70% бихевиорално); емитује `CombinedScoreResult`
  - (salience 10) *"Check ADI minimum thresholds and classify recommendation level"* — провјерава ADI прагове (физичко ≥ 50, бихевиорално ≥ 75, комбиновано ≥ 75) и одређује ниво препоруке; модификује `CombinedScoreResult`
  - (salience 5) *"Emit breed recommendation"* — креира финалну `Recommendation` чињеницу из класификованог `CombinedScoreResult`
  - (salience 1) *"Rank breed recommendations for role"* — сортира све препоруке за улогу коришћењем `accumulate()` и исписује ранг-листу
- *Међучињенице*: `CombinedScoreResult(breedName, roleId, physicalScore, behavioralScore, combinedScore, physicalOk, behavioralOk, combinedOk, meetsThreshold, recommendationLevel, reasoning)`
- *Излаз*: `Recommendation` чињенице са укупним скором и нивоом препоруке
- *Редослед извршавања*: agenda-група `"behavioral"` → `"compatibility"` (управља се преко `setFocus()`)

== Попуњавање Базе Знања

База знања се попуњава кроз следећи процес:

+ *Профили раса*: Извлаче се из `breeds.csv` коју одржава тим експерата. Сваки ред садржи физичке и бихевиоралне карактеристике расе. Шаблон `breeds.drt` генерише правила за иницијализацију `Breed` чињеница у агенда-групи `"initialization"`.

+ *Дефиниција улога*: Радне улоге и сви припадајући физички и бихевиорални захтјеви дефинишу се у `roles.csv`. Шаблон `role_requirement.drt` генерише правила која уносе `RoleRequirement` чињенице у радну меморију при покретању, такође унутар агенда-групе `"initialization"`.

  Нове улоге се додају искључиво у `roles.csv` — без измена правила. Поља улоге:

  #table(
    columns: (auto, 1fr),
    [*Поље*], [*Опис*],
    [`roleId`], [Јединствени идентификатор улоге],
    [`roleName`], [Назив улоге за приказ],
    [`minHeightCm` / `maxHeightCm`], [Прозор висине (FCI стандарди)],
    [`minWeightKg` / `maxWeightKg`], [Прозор тежине (FCI стандарди)],
    [`minReactivityScore` / `maxReactivityScore`], [Прихватљив опсег реактивности (Hart 1985)],
    [`maxAggressionScore`], [Горњи праг агресивности (ADI стандарди)],
    [`minTrainabilityScore`], [Минимална обучљивост (ADI стандарди)],
    [`parentRoleId`], [Опционо: надређена улога у хијерархији],
    [`description`], [Описни текст улоге],
  )

  _Напомена_: `requirements.drt` је празна датотека без функције и уклоњена је из пројекта.

+ *Додатна знања*: Пондери за Hart-ове факторе и прагови за препоруке дефинисани су као константе у `compatibility.drl` и могу се прилагодити на основу практичног искуства.

=== Интеракције на Основу Знања

Интеракције у систему функционишу на следећи начин:

+ Корисник подноси упит са идентификатором улоге (`RoleQuery("guide_dog")`)
+ `backward.drl` проналази одговарајућу `RoleRequirement` чињеницу (унапред учитану из `roles.csv`) и за сваку расу у бази знања ствара `ComputeBreedGoal(PHYSICAL)`
+ Три слоја правила активирају се редом (физичка → бихевиорална → компатибилност), вођена напредовањем циљева
+ На крају, систем садржи `Recommendation` чињенице рангиране по скору
+ Препоруке се представљају кориснику у опадајућем редоследу скора

== Конкретан Пример Резоновања

У следећем примеру, демонстрирамо реазумевање система за конкретан сценарио:

=== Случај: Лабрадор Ретривер за "Пса Водича за Слепе"

==== Улаз у Систем

*Корисник подноси само:*
```
insert(new RoleQuery("guide_dog"));
```

*Систем аутоматски проналази предефинисани `RoleRequirement` из `roles.csv`:*
- `roleId` = `"guide_dog"`, `roleName` = `"Guide Dog for Blind"`
- `minHeightCm` = 50, `maxHeightCm` = 65
- `minWeightKg` = 25, `maxWeightKg` = 36
- `minReactivityScore` = 5, `maxReactivityScore` = 8
- `maxAggressionScore` = 1, `minTrainabilityScore` = 8.5

*Breed*:
- name = "Labrador Retriever"
- minHeightCm = 55, maxHeightCm = 57
- minWeightKg = 25, maxWeightKg = 36
- reactivityScore = 7.0 (Hart 1985)
- aggressionScore = 2.0
- trainabilityScore = 9.0

==== Слој 1: Физичка Евалуација

*Правило 1*: "Evaluate breed height for role"
- Просечна висина: (55 + 57) / 2 = 56 cm
- Захтев: 50–65 cm
- Резултат: ✓ Одговара (56 ∈ [50, 65])
- *Емитује*: `PhysicalDimensionFit(breedName="Labrador", roleId="guide_dog", dimension="height", value=56.0, suitable=true, reasoning="Height ✓: 56.0 cm (required 50–65 cm)")`

*Правило 2*: "Evaluate breed weight for role"
- Просечна тежина: (25 + 36) / 2 = 30.5 kg
- Захтев: 25–36 kg
- Резултат: ✓ Одговара (30.5 ∈ [25, 36])
- *Емитује*: `PhysicalDimensionFit(breedName="Labrador", roleId="guide_dog", dimension="weight", value=30.5, suitable=true, reasoning="Weight ✓: 30.5 kg (required 25–36 kg)")`

*Правило 3*: "Emit physical score for breed-role pair"
- Обје димензије подесне → physicalScore = 100
- *Емитује*: `PhysicalScore(breedName="Labrador", roleId="guide_dog", physicalScore=100, reasoning="Height ✓: 56.0 cm (required 50–65 cm) | Weight ✓: 30.5 kg (required 25–36 kg)")`

==== Слој 2: Бихевиорална Евалуација

*Правило 1*: "Evaluate reactivity fitness for role"
- Раса: 7.0, Захтев: 5–8
- Резултат: ✓ Одговара (7.0 ∈ [5, 8]) → roleReactivityFit = 100%
- *Емитује*: `BehavioralFactorFit(factor="reactivity", rawScore=7.0, fitScore=100.0, reasoning="Reactivity fit: 100.0% (breed=7.0, required 5.0–8.0)")`

*Правило 2*: "Evaluate aggression fitness for role"
- Раса: 2.0, Максимум допуштен: 1
- Резултат: ✗ Минимално превишена → roleAggressionFit = 100 − ((2.0 − 1) × 15) = 85%
  (Лабрадори су познати као веома безбедни; овај мањи пренос је прихватљив)
- *Емитује*: `BehavioralFactorFit(factor="aggression", rawScore=2.0, fitScore=85.0, reasoning="Aggression fit: 85.0% (breed=2.0, max allowed=1.0)")`

*Правило 3*: "Evaluate trainability fitness for role"
- Раса: 9.0, Минимум захтеван: 8.5
- Резултат: ✓ Превишена → roleTrainabilityFit = 100 − ((10 − 9.0) × 5) = 95%
- *Емитује*: `BehavioralFactorFit(factor="trainability", rawScore=9.0, fitScore=95.0, reasoning="Trainability fit: 95.0% (breed=9.0, min required=8.5)")`

*Правило 4*: "Emit behavioral score for breed-role pair"
- behavioralScore = (95 × 0.5) + (85 × 0.3) + (100 × 0.2) = 47.5 + 25.5 + 20.0 = 93%
- *Емитује*: `BehavioralScore(breedName="Labrador", roleId="guide_dog", behavioralScore=93.0, reasoning="Hart (1985) factors — Reactivity fit: 100.0% | Aggression fit: 85.0% | Trainability fit: 95.0%")`

==== Слој 3: Компатибилност и Рангирање

*Правило 1*: "Compute combined compatibility score"
- combinedScore = (100 × 0.3) + (93 × 0.7) = 30 + 65.1 = 95.1%
- *Емитује*: `CombinedScoreResult(breedName="Labrador", roleId="guide_dog", physicalScore=100, behavioralScore=93, combinedScore=95.1)`

*Правило 2*: "Check ADI minimum thresholds and classify recommendation level"
- Физичко ≥ 50: ✓ (100 > 50)
- Бихевиорално ≥ 75: ✓ (93 > 75)
- Комбиновано ≥ 75: ✓ (95.1 > 75)
- Ниво: "Excellent" (95.1 ≥ 85)
- *Модификује*: `CombinedScoreResult` → `(physicalOk=true, behavioralOk=true, combinedOk=true, meetsThreshold=true, recommendationLevel="Excellent", reasoning="Physical: 100.0% (ADI≥50: ✓) | Behavioral: 93.0% (ADI≥75: ✓) | Combined: 95.1% (ADI≥75: ✓) | Level: Excellent")`

*Правило 3*: "Emit breed recommendation"
- *Емитује*: `Recommendation(breedName="Labrador", roleId="guide_dog", combinedScore=95.1, recommended=true, recommendationLevel="Excellent", reasoning=...)`

==== Излаз из Система

*Препоручена Раса*:
- Лабрадор Ретривер
- Скор: 95.1% (Excellent)
- Физичка компатибилност: 100%
- Бихевиорална компатибилност: 93%
- Образложење: "Hart (1985) факторе - Реактивност: 100%, Агресивност: 85%, Обучљивост: 95%"

Систем препоручује Лабрадора Ретривера као одличан избор за пса водича за слепе, пре свега због изузетне обучљивости и мирног темперамента, што директно одговара захтјевима улоге дефинисаним у ADI стандардима.

#context {
  show "Available at:": "Доступно на "
  bibliography("/literature.bib", style: "ieee")
}
