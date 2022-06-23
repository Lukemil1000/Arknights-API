INSERT INTO AFFILIATION (name) VALUES ('Babel');
INSERT INTO AFFILIATION (name) VALUES ('Iberia');
INSERT INTO AFFILIATION (name) VALUES ('Rhodes Island');
INSERT INTO AFFILIATION (name) VALUES ('Karlan Trade');

INSERT INTO CHARGE_TYPE (name) VALUES ('Per second');
INSERT INTO CHARGE_TYPE (name) VALUES ('Attacking Enemy');
INSERT INTO CHARGE_TYPE (name) VALUES ('Getting Hit');
INSERT INTO CHARGE_TYPE (name) VALUES ('Always On');

INSERT INTO SKILL_ACTIVATION (name) VALUES ('Manual Trigger');
INSERT INTO SKILL_ACTIVATION (name) VALUES ('Auto Trigger');

INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_sniper_large.png', 'Sniper');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_guard_large.png', 'Guard');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_caster_large.png', 'Caster');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_medic_large.png', 'Medic');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_specialist_large.png', 'Specialist');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_supporter_large.png', 'Supporter');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_defender_large.png', 'Defender');
INSERT INTO CLASS (icon, name) VALUES ('https://aceship.github.io/AN-EN-Tags/img/classes/black/icon_profession_vanguard_large.png', 'Vanguard');

INSERT INTO SUBCLASS (name, icon, trait, class_id) VALUES ('Artilleryman', 'https://aceship.github.io/AN-EN-Tags/img/ui/subclass/sub_aoesniper_icon.png',
'Attack deals Physical Splash Damage', 1);

INSERT INTO SUBCLASS (name, icon, trait, class_id) VALUES ('Lord', 'https://aceship.github.io/AN-EN-Tags/img/ui/subclass/sub_lord_icon.png',
'Can perform ranged attack, however attack decreased to 80% when attacking enemies with ranged attack', 2);

INSERT INTO OPERATOR (name, stars, gender, hp, attack, defense, magic_defense, redeploy, cost, block, attack_time, e1Image, e2Image, subclass_id, affiliation_id)
VALUES ('W', 6, 'Female', 1605, 912, 133, 0, 70, 29, 1, 2.8, 'https://aceship.github.io/AN-EN-Tags/img/characters/char_113_cqbw_1.png',
'https://aceship.github.io/AN-EN-Tags/img/characters/char_113_cqbw_2.png', 1, 1);

INSERT INTO OPERATOR (name, stars, gender, hp, attack, defense, magic_defense, redeploy, cost, block, attack_time, e1Image, e2Image, subclass_id, affiliation_id)
VALUES ('Thorns', 6, 'Male', 2612, 711, 402, 10, 70, 20, 2, 1.3, 'https://aceship.github.io/AN-EN-Tags/img/characters/char_293_thorns_1.png',
'https://aceship.github.io/AN-EN-Tags/img/characters/char_293_thorns_2.png', 2, 2);