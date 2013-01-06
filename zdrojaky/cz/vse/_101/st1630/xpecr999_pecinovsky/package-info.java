/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */

/*******************************************************************************
 * Balíček {@code cz.vse._101.po0000.xpecr999_literals_cmd} obsahuje třídy
 * ukázkového řešení jednoduché textové hry vytvářené v rámci semestrální práce;
 * řešení předváděné v tomto balíčku
 * vychází z řešení v balíčku {@code xpecr999_literals},
 * k němuž přidává implementaci třídy hry (třída {@link GameRUP})
 * spolu s třídou správce příkazů (třída {@link ACommand}
 * a startovacího příkazu (třída {@link CommandStart}).
 *
 * <h2>Specifika řešení v tomto balíčku</h2>
 *  <ul>
 *    <li>Definice třídy {@link GameRUP} demonstruje aplikaci zásady,
 *      že se objekt má starat pouze o to, za co je zodpovědný,
 *      a všechny ostatní záležitosti delegovat na podřízené objekty
 *      zodpovědné za příslušnou oblast.
 *      <br>&nbsp;</li>
 *    <li>Příkazy jsou definovány jako potomci společné abstraktní rodičovské
 *      třídy {@link ACommand}, přičemž rodičovský podobjekt se postará
 *      o zapamatování si jména a popisu příkazu a jejich přístupové metody.
 *      <br>&nbsp;</li>
 *    <li>Správcem příkazů je jejich rodičovská třída {@link ACommand},
 *      která rozhoduje o tom, který z jejích potomků bude reagovat
 *      na zadaný příkaz.
 *      <br>&nbsp;</li>
 * </ul>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
package cz.vse._101.st1630.xpecr999_pecinovsky;

