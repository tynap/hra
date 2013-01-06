/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */

/*******************************************************************************
 * Balíček {@code cz.vse._101.po0000.xpecr999_simple_lit} obsahuje třídy
 * ukázkového řešení jednoduché textové hry vytvářené v rámci semestrální práce;
 * řešení předváděné v tomto balíčku
 * má použité texty definovány prostřednictvím literálů;
 * řešení prozatím obsahuje pouze definici
 * správce scénářů (třída {@code ManagerWithConstants}),
 * objektů v prostorech (třída {@code Thing}),
 * batohu (třída {@link Hands})
 * a prostorů (třída {@link Room}).
 * <h2>Specifika řešení v tomto balíčku</h2>
 *  <ul>
 *    <li>Veškeré použité texty jsou definovány jako textové literály.
 *      <br>&nbsp;</li>
 *    <li>Rozhodování o typu vytvářené instance třídy {@link Thing}
 *      bere na svá bedra objekt, který o konstrukci této instance žádá.
 *      Na základě informací ukrytých v obdrženém názvu objektu pozná,
 *      o jaký objekt se jedná, a podle toho mu přiřadí i požadovanou váhu.
 *      Tu předá spolu s názvem v parametru konstruktoru daného objektu,
 *      který tak už nemusí na nic myslet.
 *      <br>&nbsp;</li>
 *    <li>Instance třídy {@link Hands}.představující batoh je definována
 *      jako jedináček, aby se zamezilo možné chybné definici
 *      dvou navzájem si konkurujících batohů.
 *      <br>&nbsp;</li>
 *    <li>Prostory (zde místnosti) jsou definovány jako instance výčtového
 *      typu {@link Room}.
 *      <br>&nbsp;</li>
 *    <li>Správcem prostorů (místností) je jejich mateřská třída {@link Room}.
 *      <br>&nbsp;</li>
 *    <li>Ve třídě {@link Room} není třeba konstruktor třídy
 *      (= statický inicializační blok), protože se vždy před začátkem hry
 *      připraví počáteční stav sousedů a objektů na základě názvů,
 *      které konstruktory místnosti uložily do příslušných polí.
 *      <br>&nbsp;</li>
 *    <li>Demonstruje možné použití konstruktoru třídy ve třídě {@link Room}
 *      v níž připraví pole obsahující počáteční sousedy každé místnosti
 *      a předměty, nacházející se v jednotlivých místnostech na počátku hry,
 *      aby se před každým začátkem hry nemusely rušit dříve vytvořené objekty
 *      a znovu vytvářet nové objekty na základě jejich názvů.
 *      Tyto demonstrační příkazy jsou ale zakomentovány,
 *      protože příslušný program je relativně složitý.
 *      <br>&nbsp;</li>
 * </ul>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
package cz.vse._101.po0000.xpecr999_literals;

