package org.devellopement.pfeback.controller;

import org.devellopement.pfeback.entities.Player;
import org.devellopement.pfeback.entities.Sponsor;
import org.devellopement.pfeback.services.PlayerServiceImpl;
import org.devellopement.pfeback.services.SponsorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class SponsorController {
    @Autowired
    SponsorServiceImpl sponsorService;
    @GetMapping("/getSponsor")
    @ResponseBody
    public List<Sponsor> getAllPlayer() {
        List<Sponsor> list = sponsorService.RetreiveAllSponsor();
        return list;
    }
    @DeleteMapping("/remove-sponsor/{sponsor-id}")
    @ResponseBody
    public void removeSponsor(@PathVariable("sponsor-id") Long id) {
        sponsorService.deleteSponsor(id);
    }
    @GetMapping("/getSponsor/{sponsor-id}")
    @ResponseBody
    public Sponsor getSponsor(@PathVariable("sponsor-id")Long id)
    {
        return sponsorService.findById(id);
    }
    @PostMapping("/Add-sponsor")
    @ResponseBody
    public Sponsor addPlayer(@RequestBody Sponsor sponsor){

        return sponsorService.addSponsor(sponsor);
    }
    @PutMapping("/{sponsor-id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable("sponsor-id") Long id, @RequestBody Sponsor modifiedSponsor) {
        Sponsor updatedSponsor = sponsorService.updateSponsor(modifiedSponsor, id);
        return ResponseEntity.ok(updatedSponsor);
    }

}
